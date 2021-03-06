package com.komoriwu.one.main.mvp;

import com.komoriwu.one.base.BasePresenter;
import com.komoriwu.one.base.BaseView;


/**
 * Created by KomoriWu
 * on 2017/9/15.
 */

public interface MainContract {
    interface View extends BaseView {
        void switchOneView();
        void switchAllView();
        void switchMeView();
    }

    interface Presenter extends BasePresenter<View> {
        void switchNavView(int id);
    }

}
