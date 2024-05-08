package com.example.demo;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Главная страница сообщества")
public class CommunityPageTest extends BaseTest {

    private final static String BASE_URL = "https://vk.com/club225299895";
    private final static String PUBLIC_TITLE = "Test public for test";
    private final static String PUBLIC_AVATAR = "https://vk.com/images/community_100.png";

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

}
