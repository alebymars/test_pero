package com.example.demo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

@DisplayName("Карточка товара")
public class ProductPageTest extends BaseTest {

    private final static String BASE_URL = "https://vk.com/club225299895?w=product-225299895_10044406";
    private final static String LOGIN_URL = "https://vk.com/login";
    private final static String FREE = "бесплатно";
    private final static String PUBLIC_TITLE = "Test public for test";
    private final static String FOR_TESTING_TEST = "For testing test";
    private final static String TESTING_PRODUCT = "testing product";
    private final static String MARKET_URL = "https://vk.com/uslugi-225299895?screen=market_item";

    ProductPage productPage = new ProductPage();

    @Test
    @DisplayName("Проверка названия группы")
    @Description("Проверяем название группы, ожидаем: " + PUBLIC_TITLE)
    public void checkPublicTitle() {
        productPage.openWebSite(BASE_URL);

        String actualTitle = productPage.getPublicTitle();
        String expectedTitle = PUBLIC_TITLE;
        String result = "Фактический результат: " + actualTitle + "\nОжидаемый результат: " + expectedTitle;

        try {
            Assertions.assertEquals(expectedTitle, actualTitle, "Ошибка. Название группы отличается.");
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка названия товара")
    @Description("Проверяем название товара, ожидаем: " + FOR_TESTING_TEST)
    public void checkItemName() {
        productPage.openWebSite(BASE_URL);

        String actualName = productPage.getItemName();
        String expectedName = FOR_TESTING_TEST;
        String result = "Фактический результат: " + actualName + "\nОжидаемый результат: " + expectedName;

        try {
            Assertions.assertEquals(expectedName, actualName, "Ошибка. Название товара отличается.");
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка цены товара")
    @Description("Проверяем цену товара, ожидаем: " + FREE)
    public void checkItemPrice() {
        productPage.openWebSite(BASE_URL);
        productPage.waitUntilTheItemPriceIsLoaded();

        String actualPrice = productPage.getItemPrice();
        String expectedPrice = FREE;
        String result = "Фактический результат: " + actualPrice + "\nОжидаемый результат: " + expectedPrice;

        try {
            Assertions.assertEquals(expectedPrice, actualPrice, "Ошибка. Цена товара отличается.");
        } catch (AssertionError e) {
            Allure.addAttachment("Ошибка", "Цена товара отличается: ожидаемая - " + expectedPrice + ", фактическая - " + actualPrice);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка описания товара")
    @Description("Проверяем описание товара, ожидаем: " + TESTING_PRODUCT)
    public void checkItemDescription() {
        productPage.openWebSite(BASE_URL);

        String actualDescription = productPage.getItemDescription();
        String expectedDescription = TESTING_PRODUCT;
        String result = "Фактический результат: " + actualDescription + "\nОжидаемый результат: " + expectedDescription;

        try {
            Assertions.assertEquals(expectedDescription, actualDescription, "Ошибка. Описание товара отличается.");
        } catch (AssertionError e) {
            Allure.addAttachment("Результат:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка плейсхолдера товара")
    @Description("Проверяем присутствует ли плейсхолдер изображения товара, ожидаем его наличие")
    public void checkExistsItemGalleryPlaceholder() {
        productPage.openWebSite(BASE_URL);

        SelenideElement placeholder = productPage.getItemGalleryPlaceholder();
        String result = "Фактический результат: true" + placeholder.exists() + "\nОжидаемый результат: true";

        try {
            Assertions.assertTrue(placeholder.exists(), "Ошибка. Плейсхолдер на странице отсутствует.");
        } catch (AssertionError e) {
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка нажатия на кнопку 'Нравится'")
    @Description("Проверяем функциональность кнопки 'Нравится': После нажатия кнопки 'Нравится' должен произойти редирект на страницу: " + LOGIN_URL)
    public void checkClickLikeButton() {
        productPage.openWebSite(BASE_URL);
        productPage.clickLikeButton();
        productPage.waitUntilTheAuthorizationFormIsLoaded();


        String actualUrl = url().substring(0, 20);
        String expectedUrl = LOGIN_URL;
        Boolean isLinksMatch = actualUrl.contains(expectedUrl);
        String result = "Фактический результат: " + actualUrl + "\nОжидаемый результат: " + expectedUrl + "\nСсылки совпадают: " + isLinksMatch;

        try {
            Assertions.assertEquals(true, isLinksMatch, "Ошибка. Ожидался редирект на страницу авторизации.");
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка нажатия на кнопку 'Поделиться'")
    @Description("Проверяем функциональность кнопки 'Поделиться': После нажатия кнопки 'Поделиться' должен появиться модальное окно с предложением 'Войти' или 'Создать аккаунт'")
    public void checkClickShareButton() {
        productPage.openWebSite(BASE_URL);
        productPage.clickShareButton();
        productPage.waitUntilTheShareBoxModalIsLoaded();

        SelenideElement shareBoxModal = productPage.getShareBoxModal();
        String result = "Фактический результат: true" + shareBoxModal.exists() + "\nОжидаемый результат: true";

        try {
            Assertions.assertTrue(shareBoxModal.exists(), "Ошибка. Отсутствует модальное окно с предложением 'Войти' или 'Создать аккаунт'.");
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка нажатия на кнопку 'Скопировать ссылку'")
    @Description("Проверяем функциональность кнопки 'Скопировать ссылку': После нажатия кнопки 'Скопировать ссылку' появляется попап с текстом 'Ссылка успешно скопирована', а в буфер обмена записывается скопированная ссылка: " + BASE_URL)
    public void checkClickCopyLinkButton() {
        productPage.openWebSite(BASE_URL);
        productPage.clickCopyLinkButton();

        String actualClipboardData = BASE_URL;
        String expectedClipboardData = clipboard().getText();
        String result = "Фактический результат: " + actualClipboardData + "\nОжидаемый результат: " + expectedClipboardData;


        try {
            Assertions.assertEquals(actualClipboardData, expectedClipboardData, "Ошибка. Скопированные данные не совпадают с ожидаемым результатом.");
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка нажатия на кнопку 'В закладки'")
    @Description("Проверяем функциональность кнопки 'В закладки': После нажатия кнопки 'В закладки' должен произойти редирект на страницу: " + LOGIN_URL)
    public void checkClickBookmarkButton() {
        productPage.openWebSite(BASE_URL);
        productPage.clickBookmarkButton();
        productPage.waitUntilTheAuthorizationFormIsLoaded();


        String actualUrl = url().substring(0, 20);
        String expectedUrl = LOGIN_URL;
        Boolean isLinksMatch = actualUrl.contains(expectedUrl);
        String result = "Фактический результат: " + actualUrl + "\nОжидаемый результат: " + expectedUrl + "\nСсылки совпадают: " + isLinksMatch;

        try {
            Assertions.assertEquals(true, isLinksMatch, "Ошибка. Ожидался редирект на страницу авторизации.");
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка нажатия на кнопку 'В желания'")
    @Description("Проверяем функциональность кнопки 'В желания': После нажатия кнопки 'В желания' должен произойти редирект на страницу: " + LOGIN_URL)
    public void checkClickWishesButton() {
        productPage.openWebSite(BASE_URL);
        productPage.clickWishesButton();
        productPage.waitUntilTheAuthorizationFormIsLoaded();


        String actualUrl = url().substring(0, 20);
        String expectedUrl = LOGIN_URL;
        Boolean isLinksMatch = actualUrl.contains(expectedUrl);
        String result = "Фактический результат: " + actualUrl + "\nОжидаемый результат: " + expectedUrl + "\nСсылки совпадают: " + isLinksMatch;

        try {
            Assertions.assertEquals(true, isLinksMatch, "Ошибка. Ожидался редирект на страницу авторизации.");
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка отображения выпадающего списка (Dropdown) при наведении курсора на кнопку «Ещё».")
    @Description("Проверяем функциональность кнопки 'Ещё': После наведения курсора на кнопку 'Ещё' ожидаем увидеть выпадающий список (Dropdown) с кнопкой 'Пожаловаться'")
    public void checkMoreButton() {
        productPage.openWebSite(BASE_URL);
        productPage.hoverMoreButton();

        SelenideElement reportButton = productPage.getReportButton();

        String result = "Появился выпадающий список с кнопкой 'Пожаловаться'? \nФактический результат: " + reportButton.exists() + "\nОжидаемый результат: true";

        try {
            Assertions.assertTrue(reportButton.exists(), "Ошибка. Отсутствует выпадающий список");
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка нажатия на кнопку 'Пожаловаться'")
    @Description("Проверяем функциональность кнопки 'Пожаловаться': После нажатия кнопки 'Пожаловаться' ожидаем увидеть модальное окно с сошибкой (потому что мы не авторизованы)")
    public void checkClickReportButton() {
        productPage.openWebSite(BASE_URL);
        productPage.hoverMoreButton();
        productPage.clickReportButton();
        productPage.waitUntilTheReportBoxModalIsLoaded();

        SelenideElement reportBoxModal = productPage.getReportBoxModal();
        String result = "Появилось модальное окно? \nФактический результат: " + reportBoxModal.exists() + "\nОжидаемый результат: true";

        try {
            Assertions.assertTrue(reportBoxModal.exists(), "Ошибка. Отсутствует модальное окно");
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка нажатия на кнопку 'Написать'")
    @Description("Проверяем функциональность кнопки 'Написать': После нажатия кнопки 'Написать' должен произойти редирект на страницу: " + LOGIN_URL)
    public void checkClickWriteButton() {
        productPage.openWebSite(BASE_URL);
        productPage.clickWriteButton();
        productPage.waitUntilTheAuthorizationFormIsLoaded();


        String actualUrl = url().substring(0, 20);
        String expectedUrl = LOGIN_URL;
        Boolean isLinksMatch = actualUrl.contains(expectedUrl);
        String result = "Фактический результат: " + actualUrl + "\nОжидаемый результат: " + expectedUrl + "\nСсылки совпадают: " + isLinksMatch;

        try {
            Assertions.assertEquals(true, isLinksMatch, "Ошибка. Ожидался редирект на страницу авторизации.");
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка нажатия на кнопку 'Подписаться'")
    @Description("Проверяем функциональность кнопки 'Подписаться': После нажатия кнопки 'Подписаться' должен произойти редирект на страницу: " + LOGIN_URL)
    public void checkClickSubscribeButton() {
        productPage.openWebSite(BASE_URL);
        productPage.waitUntilSubscribeButtonIsLoaded();
        productPage.clickSubscribeButton();
        productPage.waitUntilTheAuthorizationFormIsLoaded();


        String actualUrl = url().substring(0, 20);
        String expectedUrl = LOGIN_URL;
        Boolean isLinksMatch = actualUrl.contains(expectedUrl);
        String result = "Фактический результат: " + actualUrl + "\nОжидаемый результат: " + expectedUrl + "\nСсылки совпадают: " + isLinksMatch;

        try {
            Assertions.assertEquals(true, isLinksMatch, "Ошибка. Ожидался редирект на страницу авторизации.");
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка нажатия на кнопку 'Перейти в магазин'")
    @Description("Проверяем функциональность кнопки 'Перейти в магазин': После нажатия кнопки 'Перейти в магазин' ожидаем открытия ссылки: " + MARKET_URL + " в новой вкладке")
    public void checkClickGoToStoreButton() {
        productPage.openWebSite(BASE_URL);
        productPage.waitUntilGoToStoreButtonIsLoaded();
        productPage.clickGoToStoreButton();

        String expectedUrl = MARKET_URL;
        String actualUrl = switchTo()
                .window(1)
                .getCurrentUrl();

        Boolean isLinksMatch = actualUrl.contains(expectedUrl);
        String result = "Фактический результат: " + actualUrl + "\nОжидаемый результат: " + expectedUrl + "\nСсылки совпадают: " + isLinksMatch;

        try {
            Assertions.assertEquals(true, isLinksMatch, "Ошибка. Ожидался переход в магазин в новой вкладке.");
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка отображения карточки товара")
    @Description("Проверяем, что после перехода по ссылке: " + BASE_URL + ", открывается страница группы с открытой карточкой товара")
    public void checkCardItemInThePage() {
        productPage.openWebSite(BASE_URL);

        Boolean expectedUrl = true;
        SelenideElement actualUrl = productPage.getCardItemModal();

        String result = "Фактический результат: " + actualUrl.exists() + "\nОжидаемый результат: " + expectedUrl;

        try {
            Assertions.assertTrue(actualUrl.exists(), "Ошибка. На странице не отображается карточка товара.");
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка закрытия карточки товара")
    @Description("Проверяем, что при нажатии на кнопку с иконкой «X» карточка закрывается.")
    public void checkCloseProductCard() {
        productPage.openWebSite(BASE_URL);
        productPage.clickCloseCardButton();
        productPage.waitUntilTheProductCardIsHidden();

        Boolean expectedUrl = true;
        SelenideElement actualUrl = productPage.getCardItemModal();

        String result = "Фактический результат: " + actualUrl.exists() + "\nОжидаемый результат: " + expectedUrl;

        try {
            Assertions.assertTrue(actualUrl.exists(), "Ошибка. Карточка товара не закрыта");
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка отображения тултипа")
    @Description("Проверка отображения тултипа при наведении курсора на кнопку «Нравится»")
    public void checkTooltipLikesUsers() {
        productPage.openWebSite(BASE_URL);
        productPage.hoverLikeButton();
        productPage.waitUntilTheTooltipLikesUsers();

        Boolean expectedTooltip = true;
        SelenideElement actualTooltip = productPage.getTooltipLikesUsers();

        String result = "Фактический результат: " + actualTooltip.exists() + "\nОжидаемый результат: " + expectedTooltip;

        try {
            Assertions.assertTrue(actualTooltip.exists(), "Ошибка. Тултип не обнаружен");
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }

}
