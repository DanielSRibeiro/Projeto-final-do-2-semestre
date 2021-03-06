package com.example.techonehub.meuadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.techonehub.model.Dto.DtoSocio;
import com.example.techonehub.R;

import java.util.ArrayList;

public class MeuAdapterSocio extends RecyclerView.Adapter<MeuAdapterSocio.MeuViewHolder> {

    ArrayList<DtoSocio> arrayListDtosocio;
    OnClickItemListener listener;

    public MeuAdapterSocio(ArrayList<DtoSocio> arrayListSocio, OnClickItemListener listener) {
    this.arrayListDtosocio = arrayListSocio;
    this.listener = listener;
    }

    @NonNull
    @Override
    public MeuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.meuadapter_socio, parent, false);
        return new MeuViewHolder(item, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MeuViewHolder holder, int position) {
        holder.textViewNome.setText(arrayListDtosocio.get(position).getNm());
        holder.textViewCPF.setText("CPF: "+arrayListDtosocio.get(position).getCpf());
        holder.textViewEspecialidade.setText(arrayListDtosocio.get(position).getEspec());
    }

    @Override
    public int getItemCount() {
        return arrayListDtosocio.size();
    }

    public class MeuViewHolder extends RecyclerView.ViewHolder{

        TextView textViewNome, textViewCPF, textViewEspecialidade;

        public MeuViewHolder(@NonNull View itemView, OnClickItemListener listener) {
            super(itemView);

            textViewNome = itemView.findViewById(R.id.textViewNomeS);
            textViewCPF = itemView.findViewById(R.id.textViewCPFS);
            textViewEspecialidade = itemView.findViewById(R.id.textViewEspecialidadeS);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(getAdapterPosition());
                }
            });
        }
    }
}
