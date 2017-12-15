package com.komoriwu.one.all.fragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.komoriwu.one.R;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;
import com.komoriwu.one.widget.DCTextView;
import com.komoriwu.one.widget.FZTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by KomoriWu
 * on 2017-12-15.
 */

public class FollowCardAdapter extends RecyclerView.Adapter<FollowCardAdapter.FollowCardViewHolder> {
    private Context mContext;
    private List<FindBean.ItemListBeanX> mItemList;

    public FollowCardAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setSmallCardData(List<FindBean.ItemListBeanX> mItemList) {
        this.mItemList = new ArrayList<>();
        for (int i = mItemList.size() - 10; i < mItemList.size(); i++) {
            if (mItemList.get(i).getType().equals(Constants.FOLLOW_CARD)) {
                this.mItemList.add(mItemList.get(i));
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public FollowCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_follow_card, parent,
                false);
        return new FollowCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FollowCardViewHolder holder, int position) {
        FindBean.ItemListBeanX itemListBean = mItemList.get(position);
        Utils.displayImage(mContext, itemListBean.getData().getContent().getData().getCover().
                getFeed(), holder.ivCardCover);
        holder.tvTitle.setText(itemListBean.getData().getHeader().getTitle());
        holder.tvDescription.setText(itemListBean.getData().getHeader().getDescription());
        holder.tvTime.setText(Utils.durationFormat(itemListBean.getData().getContent().getData().
                getDuration()));
        Utils.displayImage(mContext, itemListBean.getData().getHeader().getIcon(), holder.ivCover,
                Utils.getImageOptions(R.mipmap.ic_launcher_round, 360));
    }

    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }

    class FollowCardViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_card_cover)
        ImageView ivCardCover;
        @BindView(R.id.tv_time)
        DCTextView tvTime;
        @BindView(R.id.iv_cover)
        ImageView ivCover;
        @BindView(R.id.tv_title)
        FZTextView tvTitle;
        @BindView(R.id.tv_description)
        FZTextView tvDescription;

        public FollowCardViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}