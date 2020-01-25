package com.telran.trello.tests;

import org.testng.Assert;
import com.telran.trello.model.TeamData;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;



public class TeamCreationTests extends TestBase {


    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().loginAcc();
        }
    }

    @Test
    public void teamCreationTestFromHeader() {
        int teamCountBefore = app.getTeam().getTeamsCount();

        app.getHeader().clickOnPlusButton();
        app.getTeam().selectCreateTeamFromDropDown();
        app.getTeam().fillTeamCreationForm(new TeamData()
                .withTeamName("teamName")
                .withTeamDescr("teamDescr"));

        app.getTeam().submitTeamCreation();

        app.getTeam().clickLaterButton();
        int teamCountAfter = app.getTeam().getTeamsCount();
        Assert.assertEquals(teamCountAfter, teamCountBefore + 1);
    }


    @Test(dataProvider = "validTeamsCSV", dataProviderClass = DataProviders.class)
    public void teamCreationTestFromHeaderWithDP(TeamData team) throws InterruptedException {
        int teamCountBefore = app.getTeam().getTeamsCount();

        app.getHeader().clickOnPlusButton();
        Thread.sleep(2000);
        app.getTeam().selectCreateTeamFromDropDown();
        app.getTeam().fillTeamCreationForm(team);

        app.getTeam().submitTeamCreation();

        app.getTeam().clickLaterButton();
        app.getHeader().returnToHomePage();
        int teamCountAfter = app.getTeam().getTeamsCount();
        Assert.assertEquals(teamCountAfter, teamCountBefore+1 );
    }

}
