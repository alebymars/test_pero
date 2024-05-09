package com.example.demo;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.url;

@DisplayName("Главная страница сообщества")
public class CommunityPageTest extends BaseTest {

    private final static String BASE_URL = "https://vk.com/club225299895";
    private final static String PUBLIC_TITLE = "Test public for test";
    private final static String NO_POSTS = "На стене пока нет ни одной записи";
    private final static String PUBLIC_AVATAR = "https://vk.com/images/community_100.png";
    private final static String ID_VK_URL = "https://id.vk.com/auth";
    private final static String INDEX_URL = "https://vk.com/";
    private final static String LOGIN_URL = "https://vk.com/login";
    private final static String MUSIC_URL = "https://vk.com/audio";
    private final static String VIDEO_URL = "https://vk.com/video";
    private final static String GROUPS_URL = "https://vk.com/groups/recommendations";
    private final static String SERVICES_URL = "https://vk.com/services";
    private final static String GAMES_URL = "https://vk.com/games";
    private final static String MOBILE_URL = "https://vk.com/mobile";
    private final static String RECOMMENDATIONS_URL = "https://vk.com/legal/recommendations";
    private final static String SHOW_ALL_URL = "https://vk.com/uslugi-225299895?screen=group";
    private final static String INPUT_OPENED_CLASS = "ui_tabs_search_opened";

    CommunityPage communityPage = new CommunityPage();

    @Test
    @DisplayName("Проверка названия группы")
    @Description("Проверяем название группы, ожидаем: " + PUBLIC_TITLE)
    public void checkPublicTitle() {
        communityPage.openWebSite(BASE_URL);

        String actualTitle = communityPage.getPublicTitle();
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
    @DisplayName("Проверка изображения(аватарки) группы")
    @Description("Проверяем аватарку группы, ожидаем увидеть заглушку (т.к. изображение не установлено в группе): " + PUBLIC_AVATAR)
    public void checkPublicAvatar() {
        communityPage.openWebSite(BASE_URL);

        String actualAvatar = communityPage.getPublicAvatar();
        String expectedAvatar = PUBLIC_AVATAR;
        String result = "Фактический результат: " + actualAvatar + "\nОжидаемый результат: " + expectedAvatar;

        try {
            Assertions.assertEquals(expectedAvatar, actualAvatar, "Ошибка. В группе установлено изображение, а мы ожидали заглушку: " + PUBLIC_AVATAR);
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка обложки группы")
    @Description("Проверяем обложку группы, ожидаем увидеть заглушку (т.к. изображение не установлено в группе)")
    public void checkPublicCover() {
        communityPage.openWebSite(BASE_URL);

        Boolean actualCover = communityPage.getPublicCover().contains("background-image");
        Boolean expectedCover = false;
        String result = "Фактический результат: " + actualCover + "\nОжидаемый результат: " + expectedCover;

        try {
            Assertions.assertEquals(expectedCover, actualCover, "Ошибка. В группе установлена обложка, а мы ожидали заглушку");
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка кнопки 'Регистрация' в хэдере")
    @Description("Проверяем функциональность кнопки-ссылки 'Регистрация' из шапки сайта")
    public void checkRegistrationBtnHeader() {
        communityPage.openWebSite(BASE_URL)
                .clickRegistrationBtnHeader()
                .waitUntilAuthWrapIsLoaded();

        String actualUrl = url();
        String expectedUrl = ID_VK_URL;
        boolean isMatchUrl = actualUrl.contains(expectedUrl);
        String result = "Фактический результат: " + actualUrl.substring(0, 22) + "\nОжидаемый результат: " + expectedUrl;

        try {
            Assertions.assertTrue(isMatchUrl, "Ошибка. Мы ожидали переход на " + expectedUrl + ", а перешли на " + actualUrl);
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка кнопки 'Регистрация' в левом сайдбаре")
    @Description("Проверяем функциональность кнопки 'Регистрация' из левого сайдбара")
    public void checkRegistrationBtnSidebar() {
        communityPage.openWebSite(BASE_URL)
                .clickRegistrationBtnSidebar()
                .waitUntilAuthWrapIsLoaded();

        String actualUrl = url();
        String expectedUrl = ID_VK_URL;
        boolean isMatchUrl = actualUrl.contains(expectedUrl);
        String result = "Фактический результат: " + actualUrl.substring(0, 22) + "\nОжидаемый результат: " + expectedUrl;

        try {
            Assertions.assertTrue(isMatchUrl, "Ошибка. Мы ожидали переход на " + expectedUrl + ", а перешли на " + actualUrl);
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка кнопки 'Войти' в левом сайдбаре")
    @Description("Проверяем функциональность кнопки 'Войти' из левого сайдбара")
    public void checkLoginBtnSidebar() {
        communityPage.openWebSite(BASE_URL)
                .clickLoginBtnSidebar()
                .waitUntilLoginBlockIsLoaded();

        String actualUrl = url();
        String expectedUrl = LOGIN_URL;
        boolean isMatchUrl = actualUrl.contains(expectedUrl);
        String result = "Фактический результат: " + actualUrl.substring(0, 20) + "\nОжидаемый результат: " + expectedUrl;

        try {
            Assertions.assertTrue(isMatchUrl, "Ошибка. Мы ожидали переход на " + expectedUrl + ", а перешли на " + actualUrl);
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка перехода на главную страницу по клику на логотив в хэдере")
    @Description("Проверяем функциональность: Переход на главную страницу сайта по клику на логотип в хэдере")
    public void checkHomeLinkHeader() {
        communityPage.openWebSite(BASE_URL)
                .clickHomeLinkHeader()
                .waitUntilIndexPageWrapIsLoaded();

        String actualUrl = url();
        String expectedUrl = INDEX_URL;
        String result = "Фактический результат: " + actualUrl + "\nОжидаемый результат: " + expectedUrl;

        try {
            Assertions.assertEquals(expectedUrl, actualUrl, "Ошибка. Мы ожидали переход на " + expectedUrl + ", а перешли на " + actualUrl);
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка кнопки 'Музыка' в левом сайдбаре")
    @Description("Проверяем функциональность кнопки 'Музыка' из левого сайдбара: ожидаем переход на страницу " + MUSIC_URL)
    public void checkMusicBtnSidebar() {
        communityPage.openWebSite(BASE_URL)
                .clickMusicBtnSidebar()
                .waitUntilMusicPageWrapIsLoaded();

        String actualUrl = url();
        String expectedUrl = MUSIC_URL;
        String result = "Фактический результат: " + actualUrl + "\nОжидаемый результат: " + expectedUrl;

        try {
            Assertions.assertEquals(expectedUrl, actualUrl, "Ошибка. Мы ожидали переход на " + expectedUrl + ", а перешли на " + actualUrl);
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка кнопки 'Видео' в левом сайдбаре")
    @Description("Проверяем функциональность кнопки 'Видео' из левого сайдбара: ожидаем переход на страницу " + VIDEO_URL)
    public void checkVideoBtnSidebar() {
        communityPage.openWebSite(BASE_URL)
                .clickVideoBtnSidebar()
                .waitUntilVideoPageWrapIsLoaded();

        String actualUrl = url();
        String expectedUrl = VIDEO_URL;
        String result = "Фактический результат: " + actualUrl + "\nОжидаемый результат: " + expectedUrl;

        try {
            Assertions.assertEquals(expectedUrl, actualUrl, "Ошибка. Мы ожидали переход на " + expectedUrl + ", а перешли на " + actualUrl);
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка кнопки 'Сообщества' в левом сайдбаре")
    @Description("Проверяем функциональность кнопки 'Сообщества' из левого сайдбара: ожидаем переход на страницу " + GROUPS_URL)
    public void checkGroupsBtnSidebar() {
        communityPage.openWebSite(BASE_URL)
                .clickGroupsBtnSidebar()
                .waitUntilGroupsPageWrapIsLoaded();

        String actualUrl = url();
        String expectedUrl = GROUPS_URL;
        boolean isMatchUrl = actualUrl.contains(expectedUrl);
        String result = "Фактический результат: " + actualUrl + "\nОжидаемый результат: " + expectedUrl;

        try {
            Assertions.assertTrue(isMatchUrl, "Ошибка. Мы ожидали переход на " + expectedUrl + ", а перешли на " + actualUrl);
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка кнопки 'Мини-приложения' в левом сайдбаре")
    @Description("Проверяем функциональность кнопки 'Мини-приложения' из левого сайдбара: ожидаем переход на страницу " + SERVICES_URL)
    public void checkServicesBtnSidebar() {
        communityPage.openWebSite(BASE_URL)
                .clickServicesBtnSidebar()
                .waitUntilServicesPageWrapIsLoaded();

        String actualUrl = url();
        String expectedUrl = SERVICES_URL;
        String result = "Фактический результат: " + actualUrl + "\nОжидаемый результат: " + expectedUrl;

        try {
            Assertions.assertEquals(expectedUrl, actualUrl, "Ошибка. Мы ожидали переход на " + expectedUrl + ", а перешли на " + actualUrl);
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка кнопки 'Игры' в левом сайдбаре")
    @Description("Проверяем функциональность кнопки 'Игры' из левого сайдбара: ожидаем переход на страницу " + GAMES_URL)
    public void checkGamesBtnSidebar() {
        communityPage.openWebSite(BASE_URL)
                .clickGamesBtnSidebar()
                .waitUntilGamesPageWrapIsLoaded();

        String actualUrl = url();
        String expectedUrl = GAMES_URL;
        String result = "Фактический результат: " + actualUrl + "\nОжидаемый результат: " + expectedUrl;

        try {
            Assertions.assertEquals(expectedUrl, actualUrl, "Ошибка. Мы ожидали переход на " + expectedUrl + ", а перешли на " + actualUrl);
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка кнопки 'Подписаться'")
    @Description("Проверяем функциональность кнопки 'Подписаться': ожидаем переход на страницу " + LOGIN_URL)
    public void checkSubscribeBtn() {
        communityPage.openWebSite(BASE_URL)
                .getScrollSubscribeBtn(false)
                .waitTime(1500)
                .clickSubscribeBtn()
                .waitUntilLoginBlockIsLoaded();

        String actualUrl = url();
        String expectedUrl = LOGIN_URL;
        boolean isMatchUrl = actualUrl.contains(expectedUrl);
        String result = "Фактический результат: " + actualUrl.substring(0, 20) + "\nОжидаемый результат: " + expectedUrl;

        try {
            Assertions.assertTrue(isMatchUrl, "Ошибка. Мы ожидали переход на " + expectedUrl + ", а перешли на " + actualUrl);
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка открытия ссылки 'Приложение на телефон' из левого сайдбара")
    @Description("Проверяем функциональность кнопки-ссылки 'Приложение на телефон': ожидаем открытие ссылки" + MOBILE_URL + " в новом окне")
    public void checkPhoneAppBtn() {
        communityPage.openWebSite(BASE_URL)
                .clickPhoneAppBtn();

        String expectedUrl = MOBILE_URL;
        String actualUrl = switchTo()
                .window(1)
                .getCurrentUrl();

        boolean isMatchUrl = actualUrl.contains(expectedUrl);
        String result = "Фактический результат: " + actualUrl.substring(0, 20) + "\nОжидаемый результат: " + expectedUrl;

        try {
            Assertions.assertTrue(isMatchUrl, "Ошибка. Мы ожидали переход на " + expectedUrl + ", а перешли на " + actualUrl);
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка кнопки 'Применяются рекомендательные технологии'")
    @Description("Проверяем функциональность кнопки 'Применяются рекомендательные технологии': ожидаем переход на страницу " + RECOMMENDATIONS_URL)
    public void checkRecommendationTechnologiesBtn() {
        communityPage.openWebSite(BASE_URL)
                .clickRecommendationTechnologiesBtn()
                .waitUntilRecommendationTechnologiesWrapIsLoaded();

        String actualUrl = url();
        String expectedUrl = RECOMMENDATIONS_URL;
        boolean isMatchUrl = actualUrl.contains(expectedUrl);
        String result = "Фактический результат: " + actualUrl + "\nОжидаемый результат: " + expectedUrl;

        try {
            Assertions.assertTrue(isMatchUrl, "Ошибка. Мы ожидали переход на " + expectedUrl + ", а перешли на " + actualUrl);
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка кнопки 'Показать все'")
    @Description("Проверяем функциональность кнопки 'Показать все': ожидаем переход на страницу " + SHOW_ALL_URL)
    public void checkShowAllBtn() {
        communityPage.openWebSite(BASE_URL)
                .clickShowAllBtn()
                .waitUntilMarketListWrapIsLoaded();

        String actualUrl = url();
        String expectedUrl = SHOW_ALL_URL;
        String result = "Фактический результат: " + actualUrl + "\nОжидаемый результат: " + expectedUrl;

        try {
            Assertions.assertEquals(expectedUrl, actualUrl, "Ошибка. Мы ожидали переход на " + expectedUrl + ", а перешли на " + actualUrl);
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка кнопки 'Подробная информация'")
    @Description("Проверяем функциональность кнопки 'Подробная информация': ожидаем увидеть модальное окно с подробной информацией о группе")
    public void checkDetailedInformationBtn() {
        communityPage.openWebSite(BASE_URL)
                .clickDetailedInformationBtn()
                .waitUntilDetailedInformationModalIsLoaded();

        boolean actual = communityPage.getDetailedInformationModal().exists();
        boolean expected = true;
        String result = "Фактический результат: " + actual + "\nОжидаемый результат: " + expected;

        try {
            Assertions.assertTrue(actual, "Ошибка. Модальное окно с подробной информацией о группе не отображается на странице.");
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка блока 'Подписчики'")
    @Description("Проверяем функциональность блока 'Подписчики': нажимаем на блок и ожидаем перейти на страницу " + LOGIN_URL + " потому, что не авторизованы.")
    public void checkCardFollowers() {
        communityPage.openWebSite(BASE_URL)
                .clickCardFollowersBtn()
                .waitUntilLoginBlockIsLoaded();

        String actualUrl = url();
        String expectedUrl = LOGIN_URL;
        boolean isMatchUrl = actualUrl.contains(expectedUrl);
        String result = "Фактический результат: " + actualUrl.substring(0, 20) + "\nОжидаемый результат: " + expectedUrl;

        try {
            Assertions.assertTrue(isMatchUrl, "Ошибка. Мы ожидали переход на " + expectedUrl + ", а перешли на " + actualUrl);
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка блока 'Контакты'")
    @Description("Проверяем функциональность блока 'Контакты': нажимаем на блок и ожидаем увидеть модальное окно с контактами группы")
    public void checkCardContacts() {
        communityPage.openWebSite(BASE_URL)
                .clickCardContactsBtn()
                .waitUntilContactsModalIsLoaded();

        boolean actualUrl = communityPage.getContactsModal().exists();
        boolean expectedUrl = true;
        String result = "Фактический результат: " + actualUrl + "\nОжидаемый результат: " + expectedUrl;

        try {
            Assertions.assertTrue(actualUrl, "Ошибка. Модальное окно отсутствует.");
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка переключения кнопок 'Все записи' и 'Записи сообщества'")
    @Description("Проверяем функциональность переключения кнопок 'Все записи' и 'Записи сообщества': ожидаем увидеть переключение стилей у кнопок (т.к. стена пустая переключение контента мы не увидим)")
    public void checkToggleAllWallAndPublicWallButtons() {
        communityPage.openWebSite(BASE_URL)
                .clickPublicWallBtn()
                .waitTime(1500)
                .clickAllWallBtn();

        String actualText = communityPage.getNoPosts();
        String expectedText = NO_POSTS;
        boolean isMatchText = actualText.contains(expectedText);
        String result = "Фактический результат: " + actualText + "\nОжидаемый результат: " + expectedText;

        try {
            Assertions.assertTrue(isMatchText, "Ошибка. Кнопки не переключались (при переключении кнопок меняется текст заглушки)");
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }


    @Test
    @DisplayName("Проверка поля поиска")
    @Description("Проверяем поле ввода т.е. поиск по стене сообщества (иконка лупы)")
    public void checkInputField() {
        communityPage.openWebSite(BASE_URL)
                .clickSearchIconBtn();

        String actualClass = communityPage.getSearchOpened().attr("class");
        String expectedClass = INPUT_OPENED_CLASS;
        boolean isMatchClass = actualClass != null && actualClass.contains(expectedClass);
        String result = "Фактический результат: " + actualClass + "\nОжидаемый результат: " + expectedClass;

        try {
            Assertions.assertTrue(isMatchClass, "Ошибка. Поле ввода не отображается на странице.");
        } catch (AssertionError e) {
            Allure.addAttachment("Результаты:", result);
            throw e;
        }

        Allure.addAttachment("Результаты:", result);
    }
}