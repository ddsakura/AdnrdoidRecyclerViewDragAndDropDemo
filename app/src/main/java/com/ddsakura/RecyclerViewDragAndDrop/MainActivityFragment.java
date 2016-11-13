
package com.ddsakura.RecyclerViewDragAndDrop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        RecyclerView itemRv = (RecyclerView) v.findViewById(R.id.recyclerview);
        ItemAdapter adapter = new ItemAdapter(Item.generateSampleList());
        itemRv.setAdapter(adapter);
        // itemRv.setLayoutManager(new LinearLayoutManager(getContext()));
        itemRv.setLayoutManager(new GridLayoutManager(getContext(), 3));

        ItemSimpleTouchHelper callback = new ItemSimpleTouchHelper(adapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(itemRv);

        return v;
    }
}
