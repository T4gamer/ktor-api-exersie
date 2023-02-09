package com.example.ktorsampleapp.ui.add_post

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ktorexamplelab.model.add_post.PostBody
import com.example.ktorexamplelab.ui.add_post.AddPostViewModel
import com.example.ktorsampleapp.R
import com.example.ktorsampleapp.databinding.FragmentAddPostBinding
import com.example.ktorsampleapp.utils.Resource

class AddPostFragment : Fragment(R.layout.fragment_add_post) {

    private var _binding: FragmentAddPostBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AddPostViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAddPostBinding.bind(view)
        setupViews()
    }

    private fun setupViews() {
        var slug = "Home"
        binding.apply {

            btnSubmit.setOnClickListener {
                val post = PostBody(
                    content = etContent.text.toString(),
                    picture = "https://pic-example.pic.jpg",
                    slug = slug,
                    title = etTitle.text.toString(),
                    7
                )
                viewModel.submitPost(post)
            }

            viewModel.addPostResponse.observe(viewLifecycleOwner) { response ->
                when (response) {
                    is Resource.Error -> {
                        Toast.makeText(requireContext(), response.message, Toast.LENGTH_LONG).show()
                        pbAddPost.isVisible = false
                        btnSubmit.isEnabled = true
                    }
                    is Resource.Loading -> {
                        pbAddPost.isVisible = true
                        btnSubmit.isEnabled = false
                    }
                    is Resource.Success -> {
                        pbAddPost.isVisible = false
                        //go back if posted successfully
                        findNavController().popBackStack()
                        Toast.makeText(
                            requireContext(),
                            "Successfully posted: ${response.data?.title}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }

            spinner.onItemSelectedListener = (object : OnItemSelectedListener {
                override fun onItemSelected(
                    adapter: AdapterView<*>?,
                    p1: View?,
                    pos: Int,
                    p3: Long
                ) {
                    slug = adapter?.getItemAtPosition(pos) as String
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }
            })

        }
    }
}