import {AlternativeType} from "./AlternativeType";

export type QuestionType = {
  id: number,
  question: string,
  options: Array<AlternativeType>
}
