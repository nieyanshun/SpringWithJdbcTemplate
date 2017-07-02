package com.letv.backend.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * 
 * Created by nieyanshun on 2017年7月2日
 */
@Repository
public class TestDao {

    public static class Msg {
        private String appId;
        private String appName;

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public String getAppName() {
            return appName;
        }

        public void setAppName(String appName) {
            this.appName = appName;
        }

    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Msg get() {
        return jdbcTemplate
                .query("select app_id,app_name from t_msg_app where app_id = '01305fd5bb4e4b048e79f3775fd32e95'",
                        new RowMapper<Msg>() {

                            @Override
                            public Msg mapRow(ResultSet rs, int rowNum) throws SQLException {
                                Msg msg = new Msg();
                                msg.setAppId(rs.getString("app_id"));
                                msg.setAppName(rs.getString("app_name"));
                                return msg;
                            }
                        })
                .get(0);
    }
}
