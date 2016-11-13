
package com.ddsakura.RecyclerViewDragAndDrop;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {
    TextView itemTv;
    ImageView itemIv;
    View itemView;

    public ItemViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        itemTv = (TextView) itemView.findViewById(R.id.item_tv);
        itemIv = (ImageView) itemView.findViewById(R.id.item_iv);
    }

    @Override
    public void onItemSelected() {
        itemView.setAlpha(0.5f);
    }

    @Override
    public void onItemClear() {
        itemView.setAlpha(1f);
    }
}
