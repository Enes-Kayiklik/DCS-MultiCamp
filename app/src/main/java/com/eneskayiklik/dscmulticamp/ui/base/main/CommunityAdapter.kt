package com.eneskayiklik.dscmulticamp.ui.base.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.eneskayiklik.dscmulticamp.R
import com.eneskayiklik.dscmulticamp.model.communitie.Community
import kotlinx.android.synthetic.main.one_row_community.view.*

class CommunityAdapter(
    private val list: Community
): RecyclerView.Adapter<CommunityAdapter.CustomViewHolder>() {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.one_row_community, parent, false))
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.itemView.apply {
            Glide.with(context)
                .load(list[position].banner)
                .into(icCommunity)

            setOnClickListener {
                findNavController()
                    .navigate(
                        MainFragmentDirections.actionMainFragmentToDetailFragment(list[position])
                    )
            }
        }
    }

    inner class CustomViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}