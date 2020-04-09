package com.example.photogallery;
import com.example.photogallery.db.PhotosDB;
import com.squareup.picasso.Picasso;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photogallery.model.Photo;

import java.util.List;

class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {

    private List<Photo> mPhotoItems;
    private Context context;

    public PhotoAdapter(Context context, List<Photo> photoItems) {
        this.context = context;
        mPhotoItems = photoItems;

    }

    @Override
    public PhotoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoAdapter.ViewHolder holder, int position) {
        Photo item = mPhotoItems.get(position);
        Picasso.with(this.context)
                .load("https://farm"+item.getFarm()+".staticflickr.com/"+item.getServer()+"/"+item.getId()+"_"+item.getSecret()+"_q.jpg")
                .into(holder.mImageView);
        //holder.mTextView.setText(item.getId());
        holder.itemPos = position;
        holder.itemView.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return mPhotoItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        //public TextView mTextView;
        public int itemPos;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.item_image_view);
            //mTextView = itemView.findViewById(R.id.info_text);
            itemView.setTag(this);
        }
    }

    final private View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            ViewHolder vh = (ViewHolder)view.getTag();
            int itemPos = vh.itemPos;
            Photo item = mPhotoItems.get(itemPos);
            Context context = view.getContext();
            PhotosDB db = PhotosDB.getDatabase(context);
            db.photoDao().insertPhoto(item);
            Toast.makeText(context, R.string.photo_added_text, Toast.LENGTH_SHORT).show();
        }
    };
}
