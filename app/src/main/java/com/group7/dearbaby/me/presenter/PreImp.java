package com.group7.dearbaby.me.presenter;

import android.os.Handler;

import com.group7.dearbaby.me.model.SuccessImp;
import com.group7.dearbaby.me.model.SuccessJson;
import com.group7.dearbaby.me.model.bean.User;
import com.group7.dearbaby.me.view.Shuju;
import com.group7.dearbaby.me.view.fragment.MineFragment;

import java.util.List;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class PreImp implements Success {

      private  Shuju shuju;
private SuccessJson successJson;
    public PreImp(Shuju shuju) {
        this.shuju = shuju;
        successJson=new SuccessImp();
        successJson.getJSon(this);
    }

    @Override
    public void succes(final List<User.DataBean> list) {
        if(list!=null){
            new Handler(((MineFragment)shuju).getActivity().getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    shuju.result(list);
                }
            }) ;



        }
    }


}
