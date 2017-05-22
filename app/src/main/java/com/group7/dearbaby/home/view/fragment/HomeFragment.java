package com.group7.dearbaby.home.view.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.group7.dearbaby.R;
import com.group7.dearbaby.base.BaseFragment;
import com.group7.dearbaby.home.presenter.HomePresenter;
import com.group7.dearbaby.home.presenter.HomePresenterImp;
import com.group7.dearbaby.home.view.adapter.HomeVpAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 作    者： holemsk
 * 类的用途：
 * 日    期： 2017-05-16.
 */

public class HomeFragment extends BaseFragment {


    @BindView(R.id.home_title_btn_barcode)
    ImageView homeTitleBtnBarcode;
    @BindView(R.id.home_search_title_logo)
    ImageView homeSearchTitleLogo;
    @BindView(R.id.text_hint02)
    TextView textHint02;
    @BindView(R.id.home_btn_search_layout)
    RelativeLayout homeBtnSearchLayout;
    @BindView(R.id.msg_unread_count_tv)
    ImageView msgUnreadCountTv;
    @BindView(R.id.message_icon)
    FrameLayout messageIcon;
    @BindView(R.id.home_title_tab)
    TabLayout homeTitleTab;
    @BindView(R.id.djh_one_menu_rl)
    RelativeLayout djhOneMenuRl;
    @BindView(R.id.rob_cate_viewpager)
    ViewPager robCateViewpager;
    @BindView(R.id.move_to_top_btn)
    ImageView moveToTopBtn;
    Unbinder unbinder;
    Unbinder unbinder1;
    private HomePresenter homePresenter;
    private List<String> titles;
    private List<Fragment> fragList;

    @Override
    protected View initSelfView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.activity_pull_to_refresh_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView(view);
        return view;
    }

    @Override
    public void initData() {
        titles = homePresenter.setTitle();
        fragList = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {

            fragList.add(new HomeShowDataFragment());

        }
    }

    @Override
    public void initView(View view) {

        homePresenter = new HomePresenterImp();
        initData();
        robCateViewpager.setAdapter(new HomeVpAdapter(getChildFragmentManager(), titles, getContext(), fragList));
        homeTitleTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        homeTitleTab.setupWithViewPager(robCateViewpager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.home_title_btn_barcode, R.id.message_icon})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_title_btn_barcode:
                ToastUtils.showShortToast("扫描二维码");
                break;
            case R.id.message_icon:
                ToastUtils.showShortToast("消息");
                break;
        }
    }
}
