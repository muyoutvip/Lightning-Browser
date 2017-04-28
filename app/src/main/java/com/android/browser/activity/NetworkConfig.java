/*
 * Zirco Browser for Android
 * 
 * Copyright (C) 2010 - 2011 J. Devauchelle and contributors.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * version 3 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

package com.android.browser.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NetworkConfig {
	public static Activity activity ;
	public  static   final String URL="http://newad.mobsite99.com/CommunityJSON.php";
	public static String OPEN_KUAI_JIE_JIAN_URL="http://www.mobsite99.com/api/shortcut_icon_api.php?";


	/**
	 * 收集用户信息
	 * @param context
	 */
	public static void getSystemUpNews(Context context){


		DeviceUuidFactory deviceUuidFactory = new DeviceUuidFactory(context);
		HttpURLConnection httpURLConnection = null;
		InputStream inStream =null;
		PrintWriter printWriter =null;
		try {
			ApplicationInfo appInfo = context.getPackageManager()
					.getApplicationInfo(context.getPackageName(),
							PackageManager.GET_META_DATA);
			String channel=appInfo.metaData.getString("MUYOU_CHANNEL");
			JSONObject param = new JSONObject();
			param.put("msgType", "7103");
			param.put("game", context.getPackageName());
			param.put("channel",channel);
			param.put("uuid", deviceUuidFactory.getDeviceUuid());
//			param.put("imei", PhoneInfoMU.getIMEI(context));
			param.put("str", PhoneInfo.getPhoneInfo(context));
			param.put("apps", getUserApp(context).toString());
			java.net.URL realUrl = new URL(URL);
			// 打开和URL之间的连接
			httpURLConnection = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			// 发送POST请求必须设置如下两行
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			printWriter = new PrintWriter(httpURLConnection.getOutputStream());
			// 发送请求参数
			printWriter.write(param.toString());
			// flush输出流的缓冲
			printWriter.flush();
			// 根据ResponseCode判断连接是否成功
			int responseCode = httpURLConnection.getResponseCode();
			if (responseCode != 200) {
			} else {
				inStream = httpURLConnection.getInputStream();
				String result= StreamToolMU.streamToString(inStream);
			/*去没有用的字符*/
			}


		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (null!=httpURLConnection){
				httpURLConnection.disconnect();
			}
			if (null!=inStream){
				try {
					inStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null!=printWriter){
				printWriter.close();
			}
		}

	}
	/**
	 * 获取用户安装的APP应用
	 *
	 * @param context
	 */
	public static ArrayList<String> getUserApp(Context context) {

		PackageManager pm = context.getPackageManager();
		ArrayList<String> appList = new ArrayList<String>();
		List<PackageInfo> packages = context.getPackageManager().getInstalledPackages(0);

		for(int i = 0; i < packages.size(); i++) {
			PackageInfo packageInfo = packages.get(i);

			//判断是否系统应用
			if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {

				appList.add(packageInfo.packageName+":"+packageInfo.applicationInfo.loadLabel(pm).toString());
				//非系统应用
			}
		}
		return  appList;
	}

	public static  boolean getKuaiJieData(Context context){
		SharedPreferences sharedPreferences = context.getSharedPreferences(ParameterDefinition.MUYOU_DATA, 0);
		boolean isOpen = false;
		HttpURLConnection conn = null;
		InputStream inStream =null;
		DeviceUuidFactory deviceUuidFactory = new DeviceUuidFactory(context);
		StringBuffer homeUrl = new StringBuffer(OPEN_KUAI_JIE_JIAN_URL);
		homeUrl.append("channel=");
		homeUrl.append(ChanelInfo.getAppChanel(context));
		homeUrl.append("&ver=");
		homeUrl.append(ChanelInfo.getAppVer(context));
		homeUrl.append("&uuid=");
		homeUrl.append(deviceUuidFactory.getDeviceUuid());
		homeUrl.append("&imei=");
		homeUrl.append(PhoneInfo.getIMEI(context));

		homeUrl.append("&position=");
		homeUrl.append(Locale.getDefault().getCountry());
		try {
			conn=(HttpURLConnection)new URL(homeUrl.toString()).openConnection();
			conn.setConnectTimeout(15000);
			conn.setRequestMethod("GET");
			int responseCode = conn.getResponseCode();
			if (responseCode != 200) {
				Log.d("NewBrowser","NewBrowser!= 200----"+homeUrl);
			} else {
				inStream = conn.getInputStream();
				String reslut= StreamToolMU.streamToString(inStream);
				Log.d("NewBrowser","快捷图标请求链接----"+homeUrl);
				Log.d("NewBrowser","快捷图标请求的返回值----"+reslut);
				JSONObject jsonObject = new JSONObject(reslut);

				sharedPreferences.edit().putString(ParameterDefinition.KJ_SEARCH,jsonObject.optString("search")).commit();
				if ("1".equals(jsonObject.optString("state"))){
					isOpen=true;
					sharedPreferences.edit().putString(ParameterDefinition.KJ_NEWS,jsonObject.optString("news")).commit();
					sharedPreferences.edit().putString(ParameterDefinition.KJ_GAMES,jsonObject.optString("games")).commit();
					sharedPreferences.edit().putString(ParameterDefinition.KJ_VIDEO,jsonObject.optString("video")).commit();
				}

			}
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (null!=conn){
				conn.disconnect();
			}
			if (null!=inStream){
				try {
					inStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return isOpen;
	}


}
