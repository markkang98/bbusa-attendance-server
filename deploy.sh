mvn clean install
scp -i /Users/markkang/Downloads/mark_trial_2.pem target/bbusa-0.0.1-SNAPSHOT.jar ec2-user@ec2-54-162-54-1.compute-1.amazonaws.com:~/
ssh -i "/Users/markkang/Downloads/mark_trial_2.pem" ec2-user@ec2-54-162-54-1.compute-1.amazonaws.com

killall screen
screen
java -jar bbusa-0.0.1-SNAPSHOT.jar