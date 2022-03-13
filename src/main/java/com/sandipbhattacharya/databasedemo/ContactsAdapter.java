package com.sandipbhattacharya.databasedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    Context context;
    List<Contacts> contactsList;
    RecyclerView rvPrograms;
    final View.OnClickListener onClickListener = new MyOnClickListener();
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView colLatin_Name;
        TextView colFamily;
        TextView colCommon_Name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            colLatin_Name = itemView.findViewById(R.id.item_latin_name);
            colFamily = itemView.findViewById(R.id.item_family);
            colCommon_Name = itemView.findViewById(R.id.item_common_name);
        }
    }

    public ContactsAdapter(Context context, List<Contacts> contactsList, RecyclerView rvPrograms){
        this.context = context;
        this.contactsList = contactsList;
        this.rvPrograms = rvPrograms;
    }

    @NonNull
    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_item, viewGroup, false);
        view.setOnClickListener(onClickListener);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapter.ViewHolder viewHolder, int i) {
        Contacts contact = contactsList.get(i);
        viewHolder.colLatin_Name.setText(contact.getLatinName());
        viewHolder.colCommon_Name.setText(contact.getCommonName());
        viewHolder.colFamily.setText(contact.getFamily());
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int itemPosition = rvPrograms.getChildLayoutPosition(v);
            String item = contactsList.get(itemPosition).getCommonName();
            Toast.makeText(context, item, Toast.LENGTH_SHORT).show();
        }
    }
}
