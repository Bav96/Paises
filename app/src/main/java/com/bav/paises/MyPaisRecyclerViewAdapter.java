package com.bav.paises;

import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.navigation.Navigation;

import com.bav.paises.databinding.FragmentPaisBinding;
import com.bav.paises.placeholder.PlaceholderContent;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderContent.Pais}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyPaisRecyclerViewAdapter extends RecyclerView.Adapter<MyPaisRecyclerViewAdapter.ViewHolder> {

    private final List<PlaceholderContent.Pais> mValues;

    public MyPaisRecyclerViewAdapter(List<PlaceholderContent.Pais> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentPaisBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.mContentView.setText(mValues.get(position).nombre);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView mContentView;
        public PlaceholderContent.Pais mItem;

        public ViewHolder(FragmentPaisBinding binding) {
            super(binding.getRoot());
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }

        @Override
        public void onClick(View v) {
            Bundle args = new Bundle();
            args.putParcelable("pais", mItem);
            args.putString("title", mItem.nombre);

            Navigation.findNavController(v).navigate(R.id.action_paisFragment_to_detallePaisFragment,args);
        }
    }
}