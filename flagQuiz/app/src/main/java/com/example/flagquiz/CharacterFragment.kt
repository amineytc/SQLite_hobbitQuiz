package com.example.flagquiz

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.flagquiz.databinding.FragmentCharacterBinding


class CharacterFragment : Fragment() {
    private var _binding:FragmentCharacterBinding?=null
    private val binding get() = _binding!!

    private lateinit var questions : ArrayList<Character>
    private lateinit var wrong_choices : ArrayList<Character>
    private lateinit var true_question : com.example.flagquiz.Character
    private lateinit var allChoices : HashSet<Character>
    private lateinit var vt:DatabaseAssistant

    private var question_counter = 0
    private var true_counter = 0
    private var wrong_counter = 0

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentCharacterBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vt =  DatabaseAssistant(requireContext())

        questions = Characterdao().getRandomPicture(vt)
        uploadQuestions()

        binding.buttonA.setOnClickListener {
            accurateControl(binding.buttonA)
            questionCounterCheck()
        }

        binding.buttonB.setOnClickListener {
            accurateControl(binding.buttonB)
            questionCounterCheck()
        }

        binding.buttonC.setOnClickListener {
            accurateControl(binding.buttonC)
            questionCounterCheck()
        }

        binding.buttonD.setOnClickListener {
            accurateControl(binding.buttonD)
            questionCounterCheck()
        }


    }

    fun uploadQuestions(){

        true_question = questions.get(question_counter)

        binding.imageViewCharacter.setImageResource(resources.getIdentifier(true_question.character_pic,
            "drawable",requireContext().packageName))

        wrong_choices = Characterdao().get3WrongPictureRandom(vt,true_question.character_id)

        allChoices = HashSet()
        allChoices.add(true_question)
        allChoices.add(wrong_choices.get(0))
        allChoices.add(wrong_choices.get(1))
        allChoices.add(wrong_choices.get(2))

        binding.buttonA.text = allChoices.elementAt(0).character_name
        binding.buttonB.text = allChoices.elementAt(1).character_name
        binding.buttonC.text = allChoices.elementAt(2).character_name
        binding.buttonD.text = allChoices.elementAt(3).character_name


    }

    fun questionCounterCheck(){
        question_counter++

        if(question_counter!=10){
            uploadQuestions()
        }else{
            val action = CharacterFragmentDirections.resultGecisAction(true_counter,wrong_counter)
            Navigation.findNavController(binding.buttonA).navigate(action)
            // Navigation.findNavController(binding.buttonA).navigate(R.id.resultGecisAction(true_counter,wrong_counter))
            // Navigation.findNavController(Activity())
        }

    }

    fun accurateControl(button:Button){
        val buttonText = button.text.toString()
        val trueAnswer = true_question.character_name

        if(buttonText == trueAnswer){
            true_counter++
        }else{
            wrong_counter++
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }



}