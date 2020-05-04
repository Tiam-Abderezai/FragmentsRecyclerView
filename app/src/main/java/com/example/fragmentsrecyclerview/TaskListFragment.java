package com.example.fragmentsrecyclerview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentsrecyclerview.databinding.FragmentTaskListBinding;

import java.util.ArrayList;
import java.util.List;


public class TaskListFragment extends Fragment {

    private FragmentTaskListBinding binding;
    private DetailsFragment detailsFragment = new DetailsFragment();

    public TaskListFragment() {


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_task_list, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final SharedViewModel viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        List<Item> list = new ArrayList<>();

        list.add(new Item("Monday", "Android", "Create a new project that demonstrates fragments with recyclerviews."));
        list.add(new Item("Tuesday", "Table", "Fix the broken leg of the table."));
        list.add(new Item("Wednesday", "Grocery", "Buy grocery for the week."));

        ItemAdapter adapter = new ItemAdapter(list);
        binding.recyclerView.setAdapter(adapter);
        adapter.setListener((v, position) -> {
            viewModel.setSelected(adapter.getItemAt(position));
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.container, detailsFragment)
                    .addToBackStack(null)
                    .commit();
        });
    }

}
