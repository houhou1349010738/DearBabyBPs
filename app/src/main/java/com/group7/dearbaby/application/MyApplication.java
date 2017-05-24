package com.group7.dearbaby.application;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareConfig;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;
import com.zhy.autolayout.config.AutoLayoutConifg;

import cn.smssdk.SMSSDK;

/**
 * @author holmes k
 * @date 2017.05.17
 */

public class MyApplication extends Application {

    {
        PlatformConfig.setSinaWeibo("3383892678","fbf0b15e0e2c4d88f2688255f8a9d69e","http://sns.whalecloud.com");
        PlatformConfig.setQQZone("1106030997","2wNCn7IxE3PIz7xF");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        AutoLayoutConifg.getInstance().useDeviceSize();
        UMShareAPI.get(this);
        UMShareConfig config = new UMShareConfig();
        config.isNeedAuthOnGetUserInfo(true);
        UMShareAPI.get(getApplicationContext()).setShareConfig(config);
        SMSSDK.initSDK(this, "1cfb207aa3b62", "c4715a08fbaa52917dc830b2254075da");
        Utils.init(this);
        ZXingLibrary.initDisplayOpinion(this);
    }
}
