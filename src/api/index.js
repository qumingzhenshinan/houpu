import {
  homeTeachers,
  homeStudents,
  homeCourse,
  homeLoop
} from "@/api/modules/home"

import {
  findTeacher,
} from "@/api/modules/TeacherDetails"

import {
  findStudent,
  findstuimg
} from "@/api/modules/StudentDetails"

import {
  killEndTime
} from "@/api/modules/Promotion"

import {
  AllCourse,
  coursecatalogue,
  Coursedetails,
  Coursecomment,
  SubjectQuery,
  findCourse,
  getrecommendedC,
  myCourseLise,
  selectHeader
} from "@/api/modules/Course"

import {
  ZeroCourse,
  NewCourse,
  allZeroC,
  newAllC
} from "@/api/modules/ZeroExperience"

import {
  allOrder,
  OrderDetail,
  addping
} from "@/api/modules/MyOrder"

import {
  Getmycoupon,
  DetailUsername,
  GetPhonenum,
  ExamHistoy,
  ChangePassword,
  UpdataImg,
  selectUser
} from "@/api/modules/personal"

import {
  findExamAll,
  findExamOnly,
  getAnswer,
  findPAnswer
} from "@/api/modules/exam"

import {
  getPhoneC,
  reMCUser,
  getlogin
} from "@/api/modules/start"


export default {
  homeTeachers,
  homeStudents,
  homeCourse,
  homeLoop,
  findTeacher,
  findStudent,
  findstuimg,
  killEndTime,
  AllCourse,
  ZeroCourse,
  allOrder,
  coursecatalogue,
  Coursecomment,
  Coursedetails,
  Getmycoupon,
  DetailUsername,
  findExamAll,
  findExamOnly,
  SubjectQuery,
  GetPhonenum,
  NewCourse,
  ExamHistoy,
  ChangePassword,
  UpdataImg,
  findCourse,
  getPhoneC,
  reMCUser,
  getlogin,
  getAnswer,
  getrecommendedC,
  findPAnswer,
  OrderDetail,
  allZeroC,
  newAllC,
  selectUser,
  addping,
  selectHeader,
  myCourseLise
}