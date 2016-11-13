
package com.ddsakura.RecyclerViewDragAndDrop;

import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> implements ItemTouchHelperAdapter {

    public enum DRAG_DROP_TYPE {
        ENABLE, DISABLE
    }

    final private List<Item> mItems;

    public ItemAdapter(List<Item> items) {
        this.mItems = items;
    }

    @Override
    public int getItemViewType(int position) {
        return (mItems.size() - 1 == position) ? DRAG_DROP_TYPE.DISABLE.ordinal() : DRAG_DROP_TYPE.ENABLE.ordinal();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_recycler_item, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Item item = mItems.get(position);
        TextView itemTv = holder.itemTv;
        itemTv.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        if (toPosition == mItems.size() - 1) {
            return false;
        }
        Collections.swap(mItems, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
    }
}
