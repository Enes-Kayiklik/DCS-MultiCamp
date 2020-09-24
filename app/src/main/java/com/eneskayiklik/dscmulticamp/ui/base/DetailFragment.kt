package com.eneskayiklik.dscmulticamp.ui.base

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.eneskayiklik.dscmulticamp.R
import com.eneskayiklik.dscmulticamp.model.communitiy.CommunityItem
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment: Fragment(R.layout.fragment_detail) {
    private lateinit var communityItem: CommunityItem
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupData()
        setupButtonsOnClick()
    }

    private fun setupButtonsOnClick() {
        btnInstagram.setOnClickListener {
            onClick(it)
        }

        btnMeetUp.setOnClickListener {
            onClick(it)
        }

        btnTwitter.setOnClickListener {
            onClick(it)
        }

        btnYoutube.setOnClickListener {
            onClick(it)
        }
    }

    private fun setupData() {
        communityItem = DetailFragmentArgs
            .fromBundle(requireArguments())
            .currentCommunity
        setupFragment()
    }

    private fun setupFragment() {
        if (this::communityItem.isInitialized) {
            Glide.with(this.requireContext())
                .load(communityItem.leader.photo)
                .into(imgLeadPhoto)

            Glide.with(this.requireContext())
                .load(communityItem.banner)
                .into(imgBanner)

            tvLeadName.text = communityItem.leader.name
            tvDesc.text = communityItem.description
        }
    }

    private fun onClick(v: View) {
        var url = "www.google.com"
        when (v.id) {
            R.id.btnInstagram -> url = communityItem.links.instagram
            R.id.btnMeetUp -> url = communityItem.links.participation
            R.id.btnTwitter -> url = communityItem.links.twitter
            R.id.btnYoutube -> url = communityItem.links.youtube
        }
        startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse(url)))
    }
}