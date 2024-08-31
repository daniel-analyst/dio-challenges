import {Component, OnInit} from '@angular/core';
import quizz_questions from "../../../../public/data/quizz_questions.json"
import {QuizzType} from "../../../types/QuizzType";
import {QuestionType} from "../../../types/QuestionType";

@Component({
  selector: 'app-quizz',
  standalone: true,
  templateUrl: './quizz.component.html',
  styleUrls: ['./quizz.component.css']
})

export class QuizzComponent implements OnInit {

  public quizz: QuizzType;

  public questionSelected: QuestionType;

  private readonly answers: string[];
  public answerSelected: string;

  private questionIndex: number;
  private questionMaxIndex: number;

  public finished: boolean;

  constructor() {
    this.quizz = {} as QuizzType;
    this.questionSelected = {} as QuestionType;
    this.answers = [];
    this.answerSelected = '';
    this.questionIndex = 0;
    this.questionMaxIndex = 0;
    this.finished = false;
  }

  ngOnInit(): void {
    if(quizz_questions){
      this.finished = false;
      this.quizz.title = quizz_questions.title;

      this.quizz.questions = quizz_questions.questions as Array<QuestionType>;
      this.questionSelected = this.quizz.questions[this.questionIndex] as QuestionType;

      this.questionIndex = 0;
      this.questionMaxIndex = this.quizz.questions.length;

      console.log(this.questionIndex)
      console.log(this.questionMaxIndex)
    }

  }

  playerChoose(value:string): void{
    this.answers.push(value)
    this.nextStep().then((): void => {});
  }

  async nextStep(): Promise<void> {
    this.questionIndex+=1

    if(this.questionMaxIndex > this.questionIndex){
        this.questionSelected = this.quizz.questions[this.questionIndex];
    }else{
      const finalAnswer:string = await this.checkResult(this.answers);
      this.finished = true;
      this.answerSelected = quizz_questions.results[finalAnswer as keyof typeof quizz_questions.results ];
    }
  }

  async checkResult(anwsers:string[]): Promise<string> {
    return anwsers.reduce((previous: string, current: string, i: number, arr: Array<string>): string => {
      if (
        arr.filter((item: string): boolean => item === previous).length >
        arr.filter((item: string): boolean => item === current).length
      ) {
        return previous
      } else {
        return current
      }
    })
  }

}
