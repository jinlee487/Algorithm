package Internship2020;

public class first_2 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int leftNow = -1;
        int rightNow = -1;
        for ( int i = 0; i < numbers.length; i++ ) {
            if ( hand.equals("right")) {
                if( rightNow == -1 && leftNow == -1 ) {
                    if (numbers[i] == 2 || numbers[i] == 5 || numbers[i] == 8 || numbers[i] == 0 ) {
                        answer += "R";
                    rightNow = numbers[i];
                    continue;
                    }
                }
                if ( numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7 ) {
                answer += "L";
                leftNow = numbers[i];
                } else if ( numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9 ) {
                answer += "R";
                rightNow = numbers[i];
                } else if ( numbers[i] == 2 ) {
                    if( rightNow == 2 ) {
                         answer += "R";
                        rightNow = numbers[i];
                        continue;
                    }
                    if( leftNow == 2 ) {
                        answer += "L";
                        leftNow = numbers[i];
                        continue;
                    }
                    if( rightNow == 3 || rightNow == 5 ) {
                    answer += "R";
                    rightNow = numbers[i];
                    } else if ( leftNow == 1 || leftNow == 5 ) {
                    answer += "L";
                    leftNow = numbers[i];
                    } else if( rightNow == 6 || rightNow == 8 ) {
                    answer += "R";
                    rightNow = numbers[i];
                    } else if ( leftNow == 4 || leftNow == 8 ) {
                    answer += "L";
                    leftNow = numbers[i];
                    } else if( rightNow == 9 || rightNow == 0 ) {
                    answer += "R";
                    rightNow = numbers[i];
                    } else if ( leftNow == 0 || leftNow == 7 ) {
                    answer += "L";
                    leftNow = numbers[i];
                    } else if ( rightNow == -1 ) {
                        answer += "R";
                        rightNow = numbers[i];
                    } else if ( leftNow == -1 ) {
                        answer += "L";
                    leftNow = numbers[i];
                    }
                } else if ( numbers[i] == 5 ) {
                    if( rightNow == 5 ) {
                         answer += "R";
                        rightNow = numbers[i];
                        continue;
                    }
                    if( leftNow == 5 ) {
                        answer += "L";
                        leftNow = numbers[i];
                        continue;
                    }
                    if ( rightNow == 2 || rightNow == 6 || rightNow == 8 ) {
                    answer += "R";
                    rightNow = numbers[i];
                    } else if ( leftNow == 2 || leftNow == 4 || leftNow == 8 ) {
                    answer += "L";
                    leftNow = numbers[i];
                    } else if ( rightNow == 3 || rightNow == 9 || rightNow == 0 ) {
                    answer += "R";
                    rightNow = numbers[i];
                    } else if ( leftNow == 1 || leftNow == 7 || leftNow == 0 ) {
                    answer += "L";
                    leftNow = numbers[i];
                    } else if ( rightNow == -1 ) {
                        answer += "R";
                    rightNow = numbers[i];
                    } else if ( leftNow == -1 ) {
                        answer += "L";
                    leftNow = numbers[i];
                    }
                } else if ( numbers[i] == 8 ) {
                    if( rightNow == 8 ) {
                         answer += "R";
                        rightNow = numbers[i];
                        continue;
                    }
                    if( leftNow == 8 ) {
                        answer += "L";
                        leftNow = numbers[i];
                        continue;
                    }
                    if ( rightNow == 5 || rightNow == 9 || rightNow == 0 ) {
                    answer += "R";
                    rightNow = numbers[i];
                    } else if ( leftNow == 5 || leftNow == 7 || leftNow == 0 ) {
                    answer += "L";
                    leftNow = numbers[i];
                    } else if ( rightNow == 2 || rightNow == 6 || rightNow == -1 ) {
                    answer += "R";
                    rightNow = numbers[i];
                    } else if ( leftNow == 2 || leftNow == 4 || leftNow == -1 ) {
                    answer += "L";
                    leftNow = numbers[i];
                    } else if ( rightNow == 3 ) {
                    answer += "R";
                    rightNow = numbers[i];
                    } else {
                        answer += "L";
                    leftNow = numbers[i];
                    }
                } else if ( numbers[i] == 0 ) {
                    if( rightNow == 0 ) {
                         answer += "R";
                        rightNow = numbers[i];
                        continue;
                    }
                    if( leftNow == 0 ) {
                        answer += "L";
                        leftNow = numbers[i];
                        continue;
                    }
                if ( rightNow == 8 || rightNow == -1 ) {
                    answer += "R";
                    rightNow = numbers[i];
                } else if ( leftNow == 8 || leftNow == -1 ) {
                    answer += "L";
                    leftNow = numbers[i];
                } else if ( rightNow == 5 || rightNow == 9) {
                    answer += "R";
                    rightNow = numbers[i];
                } else if ( leftNow == 5 || leftNow == 7 ) {
                    answer += "L";
                    leftNow = numbers[i];
                } else if ( rightNow == 2 || rightNow == 6 || rightNow == -1 ) {
                    answer += "R";
                    rightNow = numbers[i];
                } else if ( leftNow == 2 || leftNow == 4 || leftNow == -1 ) {
                    answer += "L";
                    leftNow = numbers[i];
                } else if ( rightNow == 3 ) {
                    answer += "R";
                    rightNow = numbers[i];
                } else if ( leftNow == 1 ){
                    answer += "L";
                    leftNow = numbers[i];
                }
            }
        } else if ( hand.equals("left")) {
                if ( leftNow == -1 && rightNow == -1 ) {
                    if (numbers[i] == 2 || numbers[i] == 5 || numbers[i] == 8 || numbers[i] == 0 ) {
                        answer += "L";
                    leftNow = numbers[i];
                    continue;
                    }
                    
                }
            
            if ( numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7 ) {
                answer += "L";
                leftNow = numbers[i];
            } else if ( numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9 ) {
                answer += "R";
                rightNow = numbers[i];
            } else if ( numbers[i] == 2 ) {
                if( rightNow == 2 ) {
                         answer += "R";
                        rightNow = numbers[i];
                        continue;
                    }
                    if( leftNow == 2 ) {
                        answer += "L";
                        leftNow = numbers[i];
                        continue;
                    }
                if ( leftNow == 1 || leftNow == 5 ) {
                    answer += "L";
                    leftNow = numbers[i];
                } else if( rightNow == 3 || rightNow == 5 ) {
                    answer += "R";
                    rightNow = numbers[i];
                } else if ( leftNow == 4 || leftNow == 8 ) {
                    answer += "L";
                    leftNow = numbers[i];
                } else if( rightNow == 6 || rightNow == 8 ) {
                    answer += "R";
                    rightNow = numbers[i];
                } else if ( leftNow == 0 || leftNow == 7 ) {
                    answer += "L";
                    leftNow = numbers[i];
                } else if( rightNow == 9 || rightNow == 0 ) {
                    answer += "R";
                    rightNow = numbers[i];
                } else if( leftNow == -1 ) {
                    answer += "L";
                    leftNow = numbers[i];
                } else if( rightNow == -1 ) {
                    answer += "R";
                    rightNow = numbers[i];
                }
            } else if ( numbers[i] == 5 ) {
                if( rightNow == 5 ) {
                         answer += "R";
                        rightNow = numbers[i];
                        continue;
                    }
                    if( leftNow == 5 ) {
                        answer += "L";
                        leftNow = numbers[i];
                        continue;
                    }
                if ( leftNow == 2 || leftNow == 4 || leftNow == 8 ) {
                    answer += "L";
                    leftNow = numbers[i];
                } else if ( rightNow == 2 || rightNow == 6 || rightNow == 8 ) {
                    answer += "R";
                    rightNow = numbers[i];
                } else if ( leftNow == 1 || leftNow == 7 || leftNow == 0 ) {
                    answer += "L";
                    leftNow = numbers[i];
                }else if ( rightNow == 3 || rightNow == 9 || rightNow == 0 ) {
                    answer += "R";
                    rightNow = numbers[i];
                } else if ( leftNow == -1 ) {
                    answer += "L";
                    leftNow = numbers[i];
                } else if ( rightNow == -1 ) {
                    answer += "R";
                    rightNow = numbers[i];
                }
            } else if ( numbers[i] == 8 ) {
                if( rightNow == 8 ) {
                         answer += "R";
                        rightNow = numbers[i];
                        continue;
                    }
                    if( leftNow == 8 ) {
                        answer += "L";
                        leftNow = numbers[i];
                        continue;
                    }
                if ( leftNow == 5 || leftNow == 7 || leftNow == 0 ) {
                    answer += "L";
                    leftNow = numbers[i];
                } else if ( rightNow == 5 || rightNow == 9 || rightNow == 0 ) {
                    answer += "R";
                    rightNow = numbers[i];
                } else if ( leftNow == 2 || leftNow == 4 || leftNow == -1 ) {
                    answer += "L";
                    leftNow = numbers[i];
                }  else if ( rightNow == 2 || rightNow == 6 || rightNow == -1 ) {
                    answer += "R";
                    rightNow = numbers[i];
                } else if ( leftNow == 1 ) {
                    answer += "L";
                    leftNow = numbers[i];
                } else if ( rightNow == 3 ) {
                    answer += "R";
                    rightNow = numbers[i];
                }
            } else if ( numbers[i] == 0 ) {
                if( rightNow == 0 ) {
                         answer += "R";
                        rightNow = numbers[i];
                        continue;
                    }
                    if( leftNow == 0 ) {
                        answer += "L";
                        leftNow = numbers[i];
                        continue;
                    }
                if ( leftNow == 8 || leftNow == -1 ) {
                    answer += "L";
                    leftNow = numbers[i];
                }else if ( rightNow == 8 || rightNow == -1 ) {
                    answer += "R";
                    rightNow = numbers[i];
                } else if ( leftNow == 5 || leftNow == 7 ) {
                    answer += "L";
                    leftNow = numbers[i];
                } else if ( rightNow == 5 || rightNow == 9) {
                    answer += "R";
                    rightNow = numbers[i];
                }  else if ( leftNow == 2 || leftNow == 4 ) {
                    answer += "L";
                    leftNow = numbers[i];
                }else if ( rightNow == 2 || rightNow == 6 ) {
                    answer += "R";
                    rightNow = numbers[i];
                }  else if ( leftNow == 1 ){
                    answer += "L";
                    leftNow = numbers[i];
                } else if ( rightNow == 3) {
                    answer += "R";
                    rightNow = numbers[i];
                }
            }
            }
        }
        return answer;
	}
}
