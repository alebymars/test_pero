package com.example.demo;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CommunityPage {

    private final SelenideElement
            PublicTitle = $x("//h1[@class='page_name']"),
            PublicAvatar = $x("//img[@class='AvatarRich__img' and contains(@src, 'images')]"), // (//img[@class='AvatarRich__img'])[1]
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
            SubscribeBtn = $x("//button[@class='FlatButton FlatButton--primary FlatButton--size-m redesigned-group-action']"),
            PhoneAppBtn = $x("//a[contains(@href, 'mobile')]"),
            RecommendationTechnologiesBtn = $x("//a[contains(@href, 'legal/recommendations')]"),
            ShowAllBtn = $x("//a[contains(@data-role, 'show-all')]"),
            DetailedInformationBtn = $x("//a[contains(@class, 'groups-redesigned-info-more')]"),
            CardFollowersBtn = $x("//a[contains(@href, 'search') and @class='module_header']"),
            CardContactsBtn = $x("//div[contains(@id, 'group_contacts')]//a[1]"),
            AllWallBtn = $x("//li[contains(@class, '_wall_tab_all')]//a"),
            PublicWallBtn = $x("//li[contains(@class, '_wall_tab_own')]//a"),
            NoPosts = $x("//div[contains(@class, 'page_block no_posts')]"),
            SearchIconBtn = $x("//a[contains(@class, 'ui_tab_search')]"),
            SearchOpened = $x("//h2[contains(@id, 'wall_tabs')]"),
            BottomBanner = $x("//div[@class='PageBottomBanner PageBottomBanner--unauth PageBottomBanner--animated PageBottomBanner--bg-blue']"),
            DetailedInformationModal = $x("//div[contains(@id, 'wk_box')]"),
            ContactsModal = $x("//div[contains(@data-testid, 'box_layout')]"),
            FooterWrap = $x("//div[contains(@id, 'footer_wrap')]"),
            AuthWrap = $x("//div[@class='vkc__AuthRoot__wrapper']"),
            LoginBlock = $x("//div[@class='page_block VkIdSignIn']"),
            IndexPageWrap = $x("//div[@class='IndexPageContent']"),
            MusicPageWrap = $x("//div[contains(@class, '_audio_page_layout audio_page_layout audio_page_layout2')]"),
            VideoPageWrap = $x("//div[@id='video_layout_contents']"),
            GroupsPageWrap = $x("//div[contains(@class, 'search_results search_empty_result search_communities_results mark_top_verified ')]"),
            ServicesPageWrap = $x("//div[contains(@class, 'AppsCatalogMainPage')]"),
            GamesPageWrap = $x("//div[contains(@class, 'GamesCatalog apps_catalog_layout GamesCatalog--catalog')]"),
            RecommendationTechnologiesWrap = $x("//div[contains(@id, 'privacy_box_content')]"),
            MarketListWrap = $x("//div[contains(@id, 'market_list_wrap')]");


    public CommunityPage openWebSite(String url) {
        open(url);
        waitUntilBottomBannerIsLoaded();
        FooterWrap.scrollIntoView(false);
        return new CommunityPage();
    }

    public CommunityPage waitTime(long ms) {
        sleep(ms);
        return new CommunityPage();
    }

    public void waitUntilBottomBannerIsLoaded() {
        BottomBanner.shouldBe(visible, Duration.ofSeconds(50));
        new CommunityPage();
    }

    public void waitUntilAuthWrapIsLoaded() {
        AuthWrap.shouldBe(visible, Duration.ofSeconds(50));
        new CommunityPage();
    }

    public void waitUntilLoginBlockIsLoaded() {
        LoginBlock.shouldBe(visible, Duration.ofSeconds(50));
        new CommunityPage();
    }

    public void waitUntilIndexPageWrapIsLoaded() {
        IndexPageWrap.shouldBe(visible, Duration.ofSeconds(50));
        new CommunityPage();
    }

    public void waitUntilMusicPageWrapIsLoaded() {
        MusicPageWrap.shouldBe(visible, Duration.ofSeconds(50));
        new CommunityPage();
    }

    public void waitUntilVideoPageWrapIsLoaded() {
        VideoPageWrap.shouldBe(visible, Duration.ofSeconds(50));
        new CommunityPage();
    }

    public void waitUntilGroupsPageWrapIsLoaded() {
        GroupsPageWrap.shouldBe(visible, Duration.ofSeconds(50));
        new CommunityPage();
    }

    public void waitUntilServicesPageWrapIsLoaded() {
        ServicesPageWrap.shouldBe(visible, Duration.ofSeconds(50));
        new CommunityPage();
    }

    public void waitUntilGamesPageWrapIsLoaded() {
        GamesPageWrap.shouldBe(visible, Duration.ofSeconds(50));
        new CommunityPage();
    }

    public void waitUntilRecommendationTechnologiesWrapIsLoaded() {
        RecommendationTechnologiesWrap.shouldBe(visible, Duration.ofSeconds(50));
        new CommunityPage();
    }

    public void waitUntilMarketListWrapIsLoaded() {
        MarketListWrap.shouldBe(visible, Duration.ofSeconds(50));
        new CommunityPage();
    }

    public void waitUntilDetailedInformationModalIsLoaded() {
        DetailedInformationModal.shouldBe(visible, Duration.ofSeconds(50));
        new CommunityPage();
    }

    public void waitUntilContactsModalIsLoaded() {
        ContactsModal.shouldBe(visible, Duration.ofSeconds(50));
        new CommunityPage();
    }

    public String getPublicTitle() {
        return PublicTitle.text();
    }

    public String getPublicAvatar() {
        return PublicAvatar.getAttribute("src");
    }

    public String getPublicCover() {
        return PublicCover.attr("style");
    }

    public String getNoPosts() {
        return NoPosts.text();
    }

    public SelenideElement getDetailedInformationModal() {
        return DetailedInformationModal;
    }

    public SelenideElement getContactsModal() {
        return ContactsModal;
    }

    public SelenideElement getSearchOpened() {
        return SearchOpened;
    }

    public CommunityPage getScrollSubscribeBtn(boolean isScroll) {
        SubscribeBtn.scrollIntoView(isScroll);
        return new CommunityPage();
    }

    public CommunityPage clickRegistrationBtnHeader() {
        RegistrationBtnHeader.click();
        return new CommunityPage();
    }

    public CommunityPage clickRegistrationBtnSidebar() {
        RegistrationBtnSidebar.click();
        return new CommunityPage();
    }

    public CommunityPage clickLoginBtnSidebar() {
        LoginBtnSidebar.click();
        return new CommunityPage();
    }

    public CommunityPage clickHomeLinkHeader() {
        HomeLinkHeader.click();
        return new CommunityPage();
    }

    public CommunityPage clickMusicBtnSidebar() {
        MusicBtnSidebar.click();
        return new CommunityPage();
    }

    public CommunityPage clickVideoBtnSidebar() {
        VideoBtnSidebar.click();
        return new CommunityPage();
    }

    public CommunityPage clickGroupsBtnSidebar() {
        GroupsBtnSidebar.click();
        return new CommunityPage();
    }

    public CommunityPage clickServicesBtnSidebar() {
        ServicesBtnSidebar.click();
        return new CommunityPage();
    }

    public CommunityPage clickGamesBtnSidebar() {
        GamesBtnSidebar.click();
        return new CommunityPage();
    }

    public CommunityPage clickSubscribeBtn() {
        SubscribeBtn.click();
        return new CommunityPage();
    }

    public void clickPhoneAppBtn() {
        PhoneAppBtn.click();
        new CommunityPage();
    }

    public CommunityPage clickRecommendationTechnologiesBtn() {
        RecommendationTechnologiesBtn.click();
        return new CommunityPage();
    }

    public CommunityPage clickShowAllBtn() {
        ShowAllBtn.click();
        return new CommunityPage();
    }

    public CommunityPage clickDetailedInformationBtn() {
        DetailedInformationBtn.click();
        return new CommunityPage();
    }

    public CommunityPage clickCardFollowersBtn() {
        CardFollowersBtn.click();
        return new CommunityPage();
    }

    public CommunityPage clickCardContactsBtn() {
        CardContactsBtn.click();
        return new CommunityPage();
    }

    public void clickAllWallBtn() {
        AllWallBtn.click();
        new CommunityPage();
    }

    public CommunityPage clickPublicWallBtn() {
        PublicWallBtn.click();
        return new CommunityPage();
    }

    public void clickSearchIconBtn() {
        SearchIconBtn.click();
        new CommunityPage();
    }
}
