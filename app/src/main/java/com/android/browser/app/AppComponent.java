package com.android.browser.app;

import javax.inject.Singleton;

import com.android.browser.BrowserTwoActivity;
import com.android.browser.activity.ReadingActivity;
import com.android.browser.activity.TabsManager;
import com.android.browser.ThemableBrowserActivity;
import com.android.browser.activity.ThemableSettingsActivity;
import com.android.browser.browser.BrowserPresenter;
import com.android.browser.constant.StartPage;
import com.android.browser.dialog.LightningDialogBuilder;
import com.android.browser.download.LightningDownloadListener;
import com.android.browser.fragment.BookmarkSettingsFragment;
import com.android.browser.fragment.BookmarksFragment;
import com.android.browser.fragment.DebugSettingsFragment;
import com.android.browser.fragment.LightningPreferenceFragment;
import com.android.browser.fragment.PrivacySettingsFragment;
import com.android.browser.fragment.TabsFragment;
import com.android.browser.search.SuggestionsAdapter;
import com.android.browser.utils.AdBlock;
import com.android.browser.utils.ProxyUtils;
import com.android.browser.view.LightningView;
import com.android.browser.view.LightningWebClient;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(BrowserTwoActivity activity);

    void inject(BookmarksFragment fragment);

    void inject(BookmarkSettingsFragment fragment);

    void inject(LightningDialogBuilder builder);

    void inject(TabsFragment fragment);

    void inject(LightningView lightningView);

    void inject(ThemableBrowserActivity activity);

    void inject(LightningPreferenceFragment fragment);

    void inject(BrowserApp app);

    void inject(ProxyUtils proxyUtils);

    void inject(ReadingActivity activity);

    void inject(LightningWebClient webClient);

    void inject(ThemableSettingsActivity activity);

    void inject(AdBlock adBlock);

    void inject(LightningDownloadListener listener);

    void inject(PrivacySettingsFragment fragment);

    void inject(StartPage startPage);

    void inject(BrowserPresenter presenter);

    void inject(TabsManager manager);

    void inject(DebugSettingsFragment fragment);

    void inject(SuggestionsAdapter suggestionsAdapter);

}
