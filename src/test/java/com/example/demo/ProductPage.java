package com.example.demo;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ProductPage {

    private final SelenideElement
            PublicTitle = $x("//div[contains(@class, 'vkuiSimpleCell__content')]//a[string-length(text()) > 0]"),
            ItemName = $x("//h1[@class=\'ItemName\']"),
            ItemDescription = $x("//div[@class='ItemDescription MarketItemCard__description']//div"),
            ItemPrice = $x("//*[@id=\'popup-sticker-market-react-container\']/div/div/div[1]/div[2]/div[2]/div[1]/div/span"),
            ItemGalleryPlaceholder = $x("//div[@class=\'ItemGallery__placeholder\']"),
            WriteButton = $x("//button[.//span[text()='Написать' or text()='Contact']]"),
            SubscribeButton = $x("//button[@class='Button-module__root--enpNU MarketItemCardShopInfo__buttonToggleSubscribeGroup vkuiButton vkuiButton--size-s vkuiButton--mode-primary vkuiButton--appearance-accent vkuiButton--align-center vkuiTappable vkuiInternalTappable vkuiTappable--hasHover vkuiTappable--hasActive vkui-focus-visible']"),
            GoToStoreButton = $x("//*[@id=\"popup-sticker-market-react-container\"]/div/div/div[2]/div/div[2]/div/div[2]/a"),
            LikeButton = $x("//button[@data-action-name=\'like\']"),
            ShareButton = $x("//button[@data-action-name=\'share\']"),
            CopyLinkButton = $x("//button[@data-action-name=\'copyUrl\']"),
            BookmarkButton = $x("//button[@data-action-name=\'favorite\']"),
            WishesButton = $x("//button[@data-action-name='wishlist']"),
            MoreButton = $x("//div[@data-testid=\'actions_dd_new\']"),
            ReportButton = $x("//li[@class=\'Dropdown__item\']"),
            CloseCardButton = $x("//div[@aria-label='Закрыть' or @aria-label='Close']"),
            SignInForm = $x("//div[@class=\'page_block VkIdSignIn\']"),
            ShareBoxModal = $x("//div[@class=\'box_body box_no_title box_no_buttons\']"),
            ReportBoxModal = $x("//div[@class=\'ModalBox-module__container--PhuMA vkuiInternalModalBox ReportForm\']"),
            CardItemModal = $x("//div[@class='wk_product_box MarketItemCard']"),
            TooltipLikesUsers = $x("//div[contains(@class, 'tt_w like_tt likes_tt_like tt_down')]");

    public void openWebSite(String url) {
        open(url);
        waitUntilTheProductCardIsLoaded();
    }

    public void waitUntilTheProductCardIsLoaded() {
        CardItemModal.scrollIntoView(false);
        CardItemModal.shouldBe(visible, Duration.ofSeconds(50));
    }

    public void waitUntilTheProductCardIsHidden() {
        CardItemModal.shouldBe(hidden, Duration.ofSeconds(50));
    }

    public void waitUntilTheItemPriceIsLoaded() {
        ItemPrice.shouldBe(visible, Duration.ofSeconds(50));
    }

    public void waitUntilTheAuthorizationFormIsLoaded() {
        SignInForm.shouldBe(visible, Duration.ofSeconds(50));
    }

    public void waitUntilTheShareBoxModalIsLoaded() {
        ShareBoxModal.shouldBe(visible, Duration.ofSeconds(50));
    }

    public void waitUntilTheReportBoxModalIsLoaded() {
        ReportBoxModal.shouldBe(visible, Duration.ofSeconds(50));
    }

    public void waitUntilTheTooltipLikesUsers() {
        TooltipLikesUsers.shouldBe(visible, Duration.ofSeconds(50));
    }

    public void waitUntilGoToStoreButtonIsLoaded() {
        GoToStoreButton.shouldBe(visible, Duration.ofSeconds(50));
    }

    public void waitUntilSubscribeButtonIsLoaded() {
        SubscribeButton.shouldBe(visible, Duration.ofSeconds(50));
    }

    public void clickWriteButton() {
        WriteButton.click();
    }

    public void clickSubscribeButton() {
        SubscribeButton.click();
    }

    public void clickGoToStoreButton() {
        GoToStoreButton.click();
    }

    public void clickLikeButton() {
        LikeButton.click();
    }

    public void clickShareButton() {
        ShareButton.click();
    }

    public void clickCopyLinkButton() {
        CopyLinkButton.click();
    }

    public void clickBookmarkButton() {
        BookmarkButton.click();
    }

    public void clickWishesButton() {
        WishesButton.click();
    }

    public void clickCloseCardButton() {
        CloseCardButton.click();
    }

    public void hoverMoreButton() {
        MoreButton.hover();
    }

    public void hoverLikeButton() {
        LikeButton.hover();
    }

    public void clickReportButton() {
        ReportButton.click();
    }

    public String getPublicTitle() {
        return PublicTitle.text();
    }

    public String getItemName() {
        return ItemName.text();
    }

    public String getItemDescription() {
        return ItemDescription.text();
    }

    public String getItemPrice() {
        return ItemPrice.text();
    }

    public String getSubscribeButton() {
        return SubscribeButton.text();
    }

    public SelenideElement getReportButton() {
        return ReportButton;
    }

    public SelenideElement getItemGalleryPlaceholder() {
        return ItemGalleryPlaceholder;
    }

    public SelenideElement getShareBoxModal() {
        return ShareBoxModal;
    }

    public SelenideElement getReportBoxModal() {
        return ReportBoxModal;
    }

    public SelenideElement getCardItemModal() {
        return CardItemModal;
    }

    public SelenideElement getTooltipLikesUsers() {
        return TooltipLikesUsers;
    }
}
