package com.xebia.bee.jira.tabpanels;

import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.plugin.projectpanel.ProjectTabPanel;
import com.atlassian.jira.plugin.projectpanel.impl.AbstractProjectTabPanel;
import com.atlassian.jira.project.Project;
import com.atlassian.jira.project.browse.BrowseContext;
import com.atlassian.jira.security.roles.ProjectRole;
import com.atlassian.jira.security.roles.ProjectRoleActors;
import com.atlassian.jira.security.roles.ProjectRoleManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;


public class UserRoleProjectTabPanel extends AbstractProjectTabPanel implements ProjectTabPanel {
    private static final Logger log = LoggerFactory.getLogger(UserRoleProjectTabPanel.class);
    private ProjectRoleManager projectRoleManager = ComponentAccessor.getComponent(ProjectRoleManager.class);
    private TreeMap people = new TreeMap();

    public Map createVelocityParams(BrowseContext ctx) {
        //Get the params object. This will hold all the values that can be accessed in the user-role-project-tab.properties file
        Map params = super.createVelocityParams(ctx);
        //Get the project object
        Project project = ctx.getProject();
        //Get all the project roles
        Collection<ProjectRole> projectRoles = projectRoleManager.getProjectRoles();
        //Iterate through each role and get the users associated with the role
        for (ProjectRole projectRole : projectRoles) {
            ProjectRoleActors roleActors = projectRoleManager.getProjectRoleActors(projectRole, project);
            people.put(projectRole.getName(), roleActors.getUsers());
        }
        params.put("people", people);
        params.put("avatarService", ComponentAccessor.getAvatarService());
        return params;
    }

    public boolean showPanel(BrowseContext context) {
        return true;
    }
}
