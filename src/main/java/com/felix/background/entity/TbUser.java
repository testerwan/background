package com.felix.background.entity;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class TbUser {


    public static final UserTableDef USER = new UserTableDef("tb_user");

    public static class UserTableDef extends TableDef {

        public QueryColumn ID = new QueryColumn(this, "id");
        public QueryColumn PASSWORD = new QueryColumn(this, "password");
        public QueryColumn LAST_LOGIN_TIME = new QueryColumn(this, "last_login_time");
        public QueryColumn USERNAME = new QueryColumn(this, "username");
        public QueryColumn NAME = new QueryColumn(this, "name");
        public QueryColumn EMAIL = new QueryColumn(this, "email");
        public QueryColumn MOBILE = new QueryColumn(this, "mobile");
        public QueryColumn ROLES = new QueryColumn(this, "roles");
        public QueryColumn DEPARTMENT = new QueryColumn(this, "department");
        public QueryColumn CURRENT_PROJECT_ID = new QueryColumn(this, "current_project_id");
        public QueryColumn DESCRIPTION = new QueryColumn(this, "description");
        public QueryColumn CREATE_BY_ID = new QueryColumn(this, "create_by_id");
        public QueryColumn CREATE_BY_NAME = new QueryColumn(this, "create_by_name");
        public QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");
        public QueryColumn UPDATE_BY_ID = new QueryColumn(this, "update_by_id");
        public QueryColumn UPDATE_BY_NAME = new QueryColumn(this, "update_by_name");
        public QueryColumn UPDATE_TIME = new QueryColumn(this, "update_time");
        public QueryColumn IS_DELETE = new QueryColumn(this, "is_delete");

        public QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, PASSWORD, LAST_LOGIN_TIME, USERNAME, NAME, EMAIL, MOBILE, ROLES, DEPARTMENT, CURRENT_PROJECT_ID, DESCRIPTION, CREATE_BY_ID, CREATE_BY_NAME, CREATE_TIME, UPDATE_BY_ID, UPDATE_BY_NAME, UPDATE_TIME, IS_DELETE};
        public QueryColumn[] ALL_COLUMNS = new QueryColumn[]{ID, PASSWORD, LAST_LOGIN_TIME, USERNAME, NAME, EMAIL, MOBILE, ROLES, DEPARTMENT, CURRENT_PROJECT_ID, DESCRIPTION, CREATE_BY_ID, CREATE_BY_NAME, CREATE_TIME, UPDATE_BY_ID, UPDATE_BY_NAME, UPDATE_TIME, IS_DELETE};


        public UserTableDef(String tableName) {
            super(tableName);
        }
    }


    public static final ProjectTableDef PROJECT = new ProjectTableDef("tb_project");

    public static class ProjectTableDef extends TableDef {

        public QueryColumn ID = new QueryColumn(this, "id");
        public QueryColumn NAME = new QueryColumn(this, "name");
        public QueryColumn OWNER_ID = new QueryColumn(this, "owner_id");
        public QueryColumn OWNER_NAME = new QueryColumn(this, "owner_name");
        public QueryColumn PROJECT_DESC = new QueryColumn(this, "project_desc");
        public QueryColumn CREATE_BY_ID = new QueryColumn(this, "create_by_id");
        public QueryColumn CREATE_BY_NAME = new QueryColumn(this, "create_by_name");
        public QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");
        public QueryColumn UPDATE_BY_ID = new QueryColumn(this, "update_by_id");
        public QueryColumn UPDATE_BY_NAME = new QueryColumn(this, "update_by_name");
        public QueryColumn UPDATE_TIME = new QueryColumn(this, "update_time");
        public QueryColumn IS_DELETE = new QueryColumn(this, "is_delete");

        public QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, NAME, OWNER_ID, OWNER_NAME, PROJECT_DESC, CREATE_BY_ID, CREATE_BY_NAME, CREATE_TIME, UPDATE_BY_ID, UPDATE_BY_NAME, UPDATE_TIME, IS_DELETE};
        public QueryColumn[] ALL_COLUMNS = new QueryColumn[]{ID, NAME, OWNER_ID, OWNER_NAME, PROJECT_DESC, CREATE_BY_ID, CREATE_BY_NAME, CREATE_TIME, UPDATE_BY_ID, UPDATE_BY_NAME, UPDATE_TIME, IS_DELETE};


        public ProjectTableDef(String tableName) {
            super(tableName);
        }
    }
}
