package com.recycler.lib;

/**
 * creater：cyy
 * time：2017/2/8
 * describe：定义{@link android.support.v7.widget.RecyclerView}OnItemClickListener点击事件
 */
public interface OnItemClickListener {
    /**
     * @param holder 操作的ViewHolder
     * @param position 点击item的位置
     */
    void onItemClick(RecyclerHolder holder, int position);
}
