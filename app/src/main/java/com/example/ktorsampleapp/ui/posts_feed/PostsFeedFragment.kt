package com.example.ktorsampleapp.ui.posts_feed

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ktorsampleapp.R
import com.example.ktorsampleapp.databinding.FragmentPostsListBinding
import com.example.ktorsampleapp.ui.PostsAdapter
import com.example.ktorsampleapp.utils.Resource

class PostsFeedFragment : Fragment(R.layout.fragment_posts_list) {

    private var _binding: FragmentPostsListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PostsFeedViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPostsListBinding.bind(view)

        setupViews()
    }

    fun setupViews() {
        val adapter = PostsAdapter()

        binding.rvPosts.adapter = adapter
        binding.apply {
            btnRetry.setOnClickListener {
                viewModel.getPosts()
            }
            fab.setOnClickListener {
                val action = PostsFeedFragmentDirections.actionPostsFeedFragmentToAddPostFragment()
                findNavController().navigate(action)
            }

        }

        viewModel.posts.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Resource.Error -> {
                    binding.apply {
                        layoutError.visibility = View.VISIBLE
                        bpPosts.visibility = View.GONE
                        tvError.text = resource.message
                    }
                }
                is Resource.Success -> {
                    binding.apply {
                        layoutError.visibility = View.GONE
                        bpPosts.visibility = View.GONE
                    }
                    adapter.submitList(resource.data)
                }
                is Resource.Loading -> {
                    binding.apply {
                        layoutError.visibility = View.GONE
                        bpPosts.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

}