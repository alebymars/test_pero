package com.example.demo;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class CommunityPage {

    private final SelenideElement
            PublicTitle = $x("//h1[@class='page_name']"),
            PublicAvatar = $x("//img[@class='AvatarRich__img' and @alt='Test public for test']"),
            PublicCover = $x("//div[@class='redesigned-group-cover__img _page_cover']"),
            RegistrationBtnHeader = $x("//a[@id='top_reg_link']"),
            RegistrationBtnSidebar = $x("//button[@id='quick_reg_button']"),
            LoginBtnSidebar = $x("//button[@class='quick_login_button flat_button button_wide']"),
            HomeLinkHeader = $x("//a[contains(@class, 'TopHomeLink')]"),
            MusicBtnSidebar = $x("//a[contains(@href, 'audio')]"),
            VideoBtnSidebar = $x("//a[contains(@href, 'video') and @class='LeftMenu__itemLink']"),
            GroupsBtnSidebar = $x("//a[contains(@href, 'groups')]"),
            ServicesBtnSidebar = $x("//a[contains(@href, 'services')]"),
            GamesBtnSidebar = $x("//a[contains(@href, 'games')]"),
            SubscribeBtn = $x("//button[contains(@class, 'FlatButton')]"),
            PhoneAppBtn = $x("//a[contains(@href, 'mobile')]"),
            RecommendationTechnologiesBtn = $x("//a[contains(@href, 'legal/recommendations')]"),
            ShowAllBtn = $x("//a[contains(@data-role, 'show-all')]"),
            DetailedInformationBtn = $x("//a[contains(@class, 'groups-redesigned-info-more')]"),
            CardFollowers = $x("//div[contains(@id, 'group_followers')]"),
            CardContacts = $x("//div[contains(@id, 'group_contacts')]"),
            AllWallBtn = $x("//li[contains(@class, '_wall_tab_all')]//a"),
            PublicWallBtn = $x("//li[contains(@class, '_wall_tab_own')]//a"),
            SearchIconBtn = $x("//a[contains(@class, 'ui_tab_search')]"),
            CloseIconBtn = $x("//div[@class='ui_search_reset']"),
            BottomBanner = $x("//div[@class='PageBottomBanner PageBottomBanner--unauth PageBottomBanner--animated PageBottomBanner--bg-blue']"),
            RegistrationBtnBottomBanner = $x("//button[contains(@data-action, 'sign_up')]"),
            LoginBtnBottomBanner = $x("//button[contains(@data-action, 'sign_in')]"),
            SectionServices = $x("//section[contains(@class, 'MarketGroupSectionServices')]"),
            SearchInputHeader = $x("//input[contains(@id, 'ts_input')]"),
            DetailedInformationModal = $x("//div[contains(@id, 'wk_box')]"),
            ContactsModal = $x("//div[contains(@data-testid, 'box_layout')]"),
            FooterWrap = $x("//div[contains(@id, 'footer_wrap')]");


    public CommunityPage openWebSite(String url) {
        open(url);
        waitUntilBottomBannerIsLoaded();
        FooterWrap.scrollIntoView(false);
        return new CommunityPage();
    }


    public CommunityPage waitUntilBottomBannerIsLoaded() {
        BottomBanner.shouldBe(visible, Duration.ofSeconds(50));
        return new CommunityPage();
    }

    public String getPublicTitle() {
        return PublicTitle.text();
    }

    public String getPublicAvatar() {
        return PublicAvatar.getAttribute("src");
    }

}
