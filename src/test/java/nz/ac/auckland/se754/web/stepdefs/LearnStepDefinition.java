package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.CourseOverviewPage;
import nz.ac.auckland.se754.web.pages.LearnPage;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LearnStepDefinition {
    private WebDriver driver;
    private LearnPage page;

    @Before
    public void setup() {
        this.driver = SharedDriver.getSharedDriverInstance().getDriver();
        this.page = new LearnPage(driver);
    }

    @AfterStep
    public void afterEachStep() {
        // to make the test at human speed
        if (System.getenv().getOrDefault("headless", "false").equals("false")) {
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @After
    public void tearDown() {
        SharedDriver.getSharedDriverInstance().quitAndResetDriver();
    }


    @Given("I visit the learning page with the id {int}")
    public void iVisitTheLearningPageWithTheId(int arg0) {
        driver.get("http://localhost:8080/learn/" + arg0);
    }

    @When("the learning page loads")
    public void theLearningPageLoads() {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:8080/learn/123";
        assertEquals(expectedUrl, actualUrl);
    }

    @Then("I should see the learning contents")
    public void iShouldSeeTheLearningContents() {
        List<String> texts = List.of("Java is an Object-Oriented Programming Language: Java is designed to be an object-oriented programming language, which means it follows the principles of encapsulation, inheritance, and polymorphism. This allows developers to create modular and reusable code, making it easier to build complex applications.", "Java is Platform-Independent: One of the key features of Java is its ability to run on multiple platforms without the need for recompilation. Java programs are compiled into bytecode, which can be executed on any platform with a Java Virtual Machine (JVM). This platform independence has made Java popular for developing cross-platform applications.", "Java has a Large and Active Community: Java has a vast community of developers and enthusiasts worldwide. The Java community actively contributes to the development of libraries, frameworks, and tools, making it easier for developers to build robust and scalable applications. The availability of resources, forums, and online communities makes Java a well-supported language for learning and development.");
        List<String>  images = List.of("https://scaler.com/topics/images/object-oriented-programming-concepts-1024x870.jpg", "https://sandeepdass003.files.wordpress.com/2016/06/api_platform-independent.jpg", "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAASwAAACoCAMAAABt9SM9AAAAxlBMVEX////hHyHfAAANbrYAYLDhGhwAYrEAZbLgExYAabQAa7UAZ7PoaGnhNjkAX7AAZLL99fb76urgDxLgAgjwrq7pdnf65eX1+PsAWK1xncvi6vOjvduBp9DR3u0AXK/Y4+/mXV731dXsj5Dzubr0xMTkRUfvoKDt8vi90OVmlsg0fLxYjsS4zOP53d388fHwqKnrhYb2y8vob3AAVKycudlEg7/iKCrnYmPlVFbiMDEldrmPsNWvxeAATqqfu9rtlpbjP0HsiYlvn3hdAAAKjElEQVR4nO2daXeiShCGx2aHBBVMDFvc4opGYzQx6o0z//9P3V4AmwQSM5MZBPr5MsLBOeV7uouq6k7Xjx8MRjnpZW1Anjg8ZG1Bjrh7ytqCHDEDnaxNyA91sMjahPxQB5dZm5AfZgBkbUJ+uAPgPmsbcsPAZGKdzEYGtaxtyAs1UGE+61TmprzJ2obcIAjmIGsb8sIczsLrrI3ICdBjCf2sjcgLG7kC7rI2Iid04cB6ydqInNAAlQpg5ayTuINaGcusrcgHPaiVYGRtRT5Ac7DCCn8n0cVazbM2Ixc8Y62usjYjD9y/GEirize3O2yl5z0PQEBatWM3r7usGJ/AAU3BCnim7zV+gn49K4POmA3RivJX910AAFuZfs91xcBaHaI791fABM+sWvqeO+yuBGoc/QKGzIZVEgM8BWUhKmH1gFkBfbZikcAV1sqMKli1Nkqlu1madLYsiWuPwqsOMOCMZPWsJJZvXoMoOxTALEuTzpbFG60GWCsWXCXRw1oZ7fB6jrNDtliRRB1rJUQ71zpYK+avEtnIldhIEmC8ZbCqQyIdEjT8Cq8PJpKOxVeJLEiSE10j7eS3JRoG4RJlOUY0sLC3N1mdNBkSNkQV9ytc/GtkadEZA+KzsI8GGtsRkgKahsJxp+0TEovtNUoBzTtqC8iLgEcaC98TQavPws/oso2jLhZnpWDGfFYXXcIbLItOBKXNx/idxKhsC00askC//irYaVVMtvqVCPRaxzSa1BwqbMdRGkuTrjIIQqAWW9ZJ5EmgfNRdMLTYBq1k6oDeNrM0g6HF6n+JPAC6KvMU+PjDB98oMw1ApTikdlqRnz/4QqkZAKrU8EBWXFmGmMYBUAnhEhVqZObhUzlQf+U7Y1slP2FAbaCRWaD1CfNjsLARqDUMRhK9SvipD+P4LC3JA3fhGxEIySHp0G7+Q3POjeZwSF8GZawHkPBHA56lPN7ovGJ5/8Sys2I42vnc1h0lDZV+QvFv6nq2PRrrqqKvhwnfKS4jl7t5XO9TfvT8Mv1FaG8VThXtv2TX+eFZYpVXV6nep/Pxjr+JyqlSSVyXw4kKV3U+eOKTakNT5DjN+labzhSnKqkcJ01P/0aztXdXsWnnahynl2BouTyHUP3PXXTT9vY7a13VH9dvPJRX5bjq6C9ZeEbsblWiFr+1nJFnD6kB0mzadssb7Z2dO15vdV6sStUqr0/eRQpDOA+l/b80OyM8nxc1FSqmKpokirzOR0B5RCiQpCmKommaVNW58cpLmG52WcSCeI41EXksC9RFVVQM/EfRoIBIQZ7zrdW0leaWRhLHiWWKTKFHmu5XO9caj33MeGy57s7Zw7n5me8ew4Gp/RMr889Qh7Nwl7UVOcFXoMfL2oh/z2/FSg4MHG5b323KudMa/84bzYOT8LYEQVaMpn+7/o2vQa1UvkxvQoRdVdTJZw8N39Vv9jonbctVoPkReOnJNK3UAlMd19f4qhp3Thav8Ku/b9y54Yoo6ZFEnluP3d1qPx1hSK6j6jBkVXBipLvHwWVved0qQQL9HktXOJImwsgdBu4STAQlnOuoJH3kiJq6H44+95F3SzcDA2xLhFkil4KqSFWeGzvRNNzfrr9Q1ykg3gr5JUlSgvwQDjKYQ0tVUVfWrkPn0ENrX8r594Zma+SgFJEkiBZMD6deeSrsDAYjVwx3Zctcfh/r1s/ahNzAaZyUttTa9PasvkexRxmPxm/HO2qdp2l7I8f1FV6UNOk1YwvPCPs2SHfQSo4YrvGIUCUlCOyl1IFXPka8lpbtBGg3aulqomk0XV5Kzw41ntsxqSiae58PqzFHmWAWLYq+U/qsZzjd+ZPtmC4geI61VtBqvYiAXmsy3qVWBcuD56o3N/4+UYih3fI8r2V/WrGyyxDHNneKeDv5hpqUWHxH5uqaqn3HEtbwpuhVeE9SYNj0HRPIU5SCx14ejj/VP97b2NxPHv2Ca4X2zCIU8Q/2sNtTd3LzuC6+e3f1IJJSqvp6l77zKpGhN11ZE17Xb7ld9CJtFngFf7rlpWApR0V7+pS1hYrtrdg+yYjmMNgvafkTTRfFKkod/Vcq5PCKvQEXRaMcWjzFmyTD9Bnnz1WV224nkO12y2n4llglGwPRXsCqvrWcWLjQ8v8rw7KYPXLc8USCoyXYJKlGKQ4m/KyQSoS0Rtsl4/8FdPL6TUl2lBJsOMtWrjVeTzitytOIGjdZj/EkTdgvOdz7ushvix+WfkAz5KOH4OuQ4yWJnxTYt38HLejwJCiUJCpu2UaVvVqNTgofhi1UY+Z0tGVEEnl/VTalMLYz1v6TJr5Fdht5XqtlQ1qtlueNpvvXnQujBgn9GUEVRQ7Q07v7UgoVASeXteb0m4DbCB2BvT3aveWcNgpLQtMm42nvOK+vr46zx4PthNIWg8FgMBiMwnJfR2RtRU5oAwg7jOc0LuTYUeaMj2BifQEm1hdgYn0BJtYXYGJ9ASbWF3gn1vVDr9Hond7ivt5Bzz+UojFWTKzOoQ9C2sEp+Qt8RcX4T+ianK9837iInn/BZ71eddq94naqo8SaV4AZnJCPTgUG5Fhg0qqP6uUEwnZFnQ0AcvS8AJ6govMfi0MpxLpArXYME44Sg3TZIWqB+OHT+Oxu3JwBH6cvo+dNrJlsFv1sXEqsBvzZl1eDRq/RfaJahZE2YZEO+OhufEp8DT4vXxwavd6ANDE3i96WhxJrdnGcQLjdPenAgAfQscv2wIz6abbn0TGAszcd/opJWuiA7lcM/BHEzjVfyomdne6i2Vlg0sQisw1/fJbpQYMa8CT17ouPv2KSJtY1iDxVgx4092k9f/spIhaJE8TC+hhBKyc83YyE/6jMYtWPYpFOkIFAXSOlGV0pxao9NA6/FosrqqnAwDy2HMWaxFzTrDfoLhaLlxL0IY2LdX+4RDGmYRgy1eoKT0kDn6xci6IsQq8dPE9ChzKJ1SX5joyg+4Kh9kQktsI9IqOGmncCzneE6PkSiXWJ0z4gbC6Wywu6t0fXCF+BqL101MivC1DXcgD6z8vl8qlcYvVRbmjOyRyjHTxJprFGqBddGDjgLn7gKjhPv1wOHoVTQiXMAa9psXDEiWYfarwTdqarxcPQcomFmiEf+xnGxQqT6YN5bKyG3pFUg/dSiVWLqfNGrDDze6FmIWoATKlTKrFmx2QQERcrqPjV6X7JL7GRWC6xOvEIqh4XCz0mP89NShAUT5jHvmGlEgurE/34OvJglFg9XN37KVCDD6lzDLkWZllCh5/oE1UcrR2AEG9Wiz0aqs4c88IFdvqkc9jdk1mGoBS5aTI+FuT3brrdNjArshlvONcPm/1GbYpIH27zadG9kqG2b9c1ishGCJcjamQ0CTgvBJueGRNrTtrXRu4dcgGC51EhAiDtii4WctNBzXhmBithggnm8O0oy5RY1wBnjLGCQztcCTPARe3HiyEXXaxjQQFyqJD10gEUqbZptzfU2tZzGxP7cm9DFlhxyvNr094Uu6w8e1M6v591Zl9a/Zt1OqXZkUpeaaX5uX/EdZghMz6nIhwLxowPqT/hCl/RF92/hQYOrABrOH4KL/JxqwzjE2oyjD6LHRl9I9dU73EGgxHxP7Qh0pJ2T/FnAAAAAElFTkSuQmCC");
        List<String>  videos = List.of("https://www.youtube.com/embed/mG4NLNZ37y4");
        String image1Src = page.getImage_1().getAttribute("src");
        String image2Src = page.getImage_2().getAttribute("src");
        String image3Src = page.getImage_3().getAttribute("src");
        String text1 = page.getText_1().getText();
        String text2 = page.getText_2().getText();
        String text3 = page.getText_3().getText();
        String videoSrc = page.getVideo_1().getAttribute("src");

        assertEquals(images.get(0), image1Src);
        assertEquals(images.get(1), image2Src);
        assertEquals(images.get(2), image3Src);
        assertEquals(texts.get(0), text1);
        assertEquals(texts.get(1), text2);
        assertEquals(texts.get(2), text3);
        assertEquals(videos.get(0), videoSrc);
    }
}
