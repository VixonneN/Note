package com.example.noteproject.screens.note

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.noteproject.R
import com.example.noteproject.databinding.FragmentAddNewNoteBinding
import com.example.noteproject.databinding.FragmentMainBinding
import com.example.noteproject.databinding.FragmentNoteBinding
import com.example.noteproject.models.AppNote
import com.example.noteproject.screens.add_new_note.AddNewNoteFragmentViewModel
import com.example.noteproject.utilits.APP_ACTIVITY


class NoteFragment : Fragment() {

    private var binding: FragmentNoteBinding? = null
    private val mBinding get() = binding!!

    private lateinit var mViewModel: NoteFragmentViewModel

    private lateinit var mCurrentNote:AppNote


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteBinding.inflate(layoutInflater, container, false)
        mCurrentNote = arguments?.getSerializable("note") as AppNote
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        setHasOptionsMenu(true)
        binding!!.noteText.text = mCurrentNote.text
        binding!!.noteName.text = mCurrentNote.name
        mViewModel = ViewModelProvider(this).get(NoteFragmentViewModel::class.java)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.note_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.btn_delete -> {
                mViewModel.delete(mCurrentNote){
                    APP_ACTIVITY.navController.navigate(R.id.action_noteFragment_to_mainFragment)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}