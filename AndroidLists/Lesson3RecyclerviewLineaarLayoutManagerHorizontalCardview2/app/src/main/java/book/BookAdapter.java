package book;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhuy.lesson3recyclerviewlineaarlayoutmanagerhorizontalcardview2.R;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHodler> {

    private List<Book> mBook;

    public void setData(List<Book> list){
        this.mBook = list;
        //tải dữ liệu lên cho BookAdapter
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BookViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //khai báo view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book,parent,false);
        return new BookViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHodler holder, int position) {
    //khai báo Book
        Book book = mBook.get(position);
        if(book == null){
            return;
        }
        holder.imgBook.setImageResource(book.getResourceId());
        holder.tvTitle.setText(book.getTitle());
    }

    @Override
    public int getItemCount() {
        if(mBook != null){
            return mBook.size();
        }
        return 0;
    }

    public class BookViewHodler extends RecyclerView.ViewHolder{
        //khai báo các thành phần trong view
        private ImageView imgBook;
        private TextView tvTitle;

        public BookViewHodler(@NonNull View itemView) {
            super(itemView);

            //ánh xạ view thông qua phương thức FindViewById
            // ctrl + d nhấn enter: dùng copy dòng trên không càn bôi đen
            imgBook = itemView.findViewById(R.id.img_book);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }
}
