package com.xtp.books.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xtp.books.R;
import com.xtp.books.entity.BookBean;
import com.xtp.books.ui.rx.RxJava2Activity;
import com.xtp.books.util.GlideUtil;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ItemHolder> {
    private Context context;
    private List<BookBean> mData;

    public BookAdapter(Context context) {
        this.context = context;
        mData = new ArrayList<>();
    }

    public void setData(List<BookBean> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(context).inflate(R.layout.book_recycle_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, final int position) {
        BookBean bean = mData.get(position);
        GlideUtil.load(context, holder.ivCover, bean.cover);
        holder.tvTitle.setText(bean.title);
        holder.tvAuthor.setText("作者:" + bean.author);
        holder.tvPublisher.setText("出版社:" + bean.publisher);
        holder.tvDate.setText("出版年: " + bean.date);
        holder.tvIsbn.setText("ISBN: " + bean.ISBN);
        holder.flRoot.setOnClickListener(v -> {
            if (position == 0) {
                Intent i = new Intent(context, RxJava2Activity.class);
                context.startActivity(i);
            }
            if (position == 1) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ItemHolder extends RecyclerView.ViewHolder {
        FrameLayout flRoot;
        ImageView ivCover;
        TextView tvTitle;
        TextView tvAuthor;
        TextView tvPublisher;
        TextView tvDate;
        TextView tvIsbn;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            flRoot = itemView.findViewById(R.id.flRoot);
            ivCover = itemView.findViewById(R.id.ivCover);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvPublisher = itemView.findViewById(R.id.tvPublisher);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvIsbn = itemView.findViewById(R.id.tvIsbn);
        }
    }
}
