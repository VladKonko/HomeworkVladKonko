package com.telran.trello.tests;

import org.testng.Assert;
import com.telran.trello.model.TeamData;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.getSession().isAvatarPresentOnHeader()){
            app.getSession().loginAcc();
        }
    }
    @Test
    public void teamCreationTestFromHeader(){
        int teamCountBefore = app.getTeam().getTeamsCount();
//    String teamId =
//            wd.findElement(By.cssSelector("[data-test-id^=home-team-tab-section]")).getAttribute("data-test-id");
        // System.out.println(teamId);
        app.getHeader().clickOnPlusButton();
        app.getTeam().selectCreateTeamFromDropDown();
        app.getTeam().fillTeamCreationForm(new TeamData()
                .withTeamName("teamName")
                .withTeamDescr("teamDescr"));

        app.getTeam().submitTeamCreation();
//    if(isElementPresent(By.cssSelector("[name='close']"))){
//      closeInviteToTheTeamForm();
//    }
        app.getTeam().clickLaterButton();
        int teamCountAfter = app.getTeam().getTeamsCount();
        Assert.assertEquals(teamCountAfter, teamCountBefore+1);
    }
    @Test
    public void teamCreationTestFromHeaderWithNameOnly(){
        int teamCountBefore = app.getTeam().getTeamsCount();
//    String teamId =
//            wd.findElement(By.cssSelector("[data-test-id^=home-team-tab-section]")).getAttribute("data-test-id");
        // System.out.println(teamId);
        app.getHeader().clickOnPlusButton();
        app.getTeam().selectCreateTeamFromDropDown();
        app.getTeam().fillTeamCreationForm(new TeamData()
                .withTeamName("teamName"));

        app.getTeam().submitTeamCreation();
//    if(isElementPresent(By.cssSelector("[name='close']"))){
//      closeInviteToTheTeamForm();
//    }
        app.getTeam().clickLaterButton();
        int teamCountAfter = app.getTeam().getTeamsCount();
        Assert.assertEquals(teamCountAfter, teamCountBefore+1);
    }

}