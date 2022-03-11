package category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nhuy.lesson3recyclerviewlineaarlayoutmanagerhorizontalcardview2.R;

import java.util.List;

import book.Book;
import book.BookAdapter;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CatagoryAdapterHolder> {

    private Context mContext;
    private List<Category> mListCategory;

    public CategoryAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Category> list){
        this.mListCategory = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CatagoryAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
        return new CatagoryAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatagoryAdapterHolder holder, int position) {
    // nếu như null return ngược lại xét dữ liệu
        Category category = mListCategory.get(position);
        if(category == null){
            return;
        }

        holder.tvNameCategory.setText(category.getNameCategory());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL,false);
        holder.revBook.setLayoutManager(linearLayoutManager);

        BookAdapter bookAdapter = new BookAdapter();
        bookAdapter.setData(category.getBooks());
        holder.revBook.setAdapter(bookAdapter);
    }

    @Override
    public int getItemCount() {
        if(mListCategory != null){
            return mListCategory.size();
        }
        return 0;
    }

    public class CatagoryAdapterHolder extends RecyclerView.ViewHolder{

        //khai báo các thành phần
        private TextView tvNameCategory;
        private RecyclerView revBook;

        public CatagoryAdapterHolder(@NonNull View itemView) {
            super(itemView);

            //ánh xạ view
            tvNameCategory = itemView.findViewById(R.id.tv_name_category);
            revBook = itemView.findViewById(R.id.rcv_book);
        }
    }
}
