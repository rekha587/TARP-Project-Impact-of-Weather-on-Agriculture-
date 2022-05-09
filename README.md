# TARP-Project-Impact-of-Weather-on-Agriculture 
  

Agriculture is the main occupation of our country engaging more than 50% of Indian work force. 
India is the second largest producer of wheat and rice in the world. However lack of knowledge 
regarding climatic conditions and soil results in poor productivity of the crops. Crop selection 
and changing climatic conditions are the two major problems faced among the farmers. Each 
crop has its own suitable climatic features. This can be handled with the help of precise farming 
techniques. With the help of IOT and Machine Learning these problems can be tackled 
efficiently. The system built in this project uses a perfect blend of IOT and Machine Learning to 
improve the crop production by studying the soil nutrients and climatic conditions. In addition to 
its basic functionality of predicting the crop, the project also focuses on real time monitoring of 
weather elements such as temperature, pressure and humidity along with their visual 
representation. The system also provides an easy tracking of the crop life cycle from sowing the 
seeds till the harvest of the crop giving periodic reminders regarding pesticides and irrigation of 
the crops. The system provides an easy user interface which helps user to interact with the model 
conveniently. 
The project aims at tackling problems of the agriculture sector with the efficient use of modern 
scientific methods, thus increasing the GDP of the country.

# REQUIREMENTS:
## HARDWARE REQUIREMENTS
The proposed used consists of the following hardware components:
1. Arduino Uno
2. BMP – 180 sensors
3. DHT11 sensor
4. GSM module
5. LCD display
6. Connecting Wires
7. SIM card
GSM module is used to connect to the cloud i.e., Thingspeak.
## SOFTWARE REQUIREMENTS
In the software simulation the design of the circuit is constructed using Proteus Professional
software. The coding for the hardware implementation is done using Arduino software. 
The mobile application is implemented using:
1.  Android Studio (Java language)
The machine learning model is built using:
2. Python
Some of the libraries handy in building the project are numpy, sklearn, pandas and pickle-mixin.
The model was finally converted into an API using flask module

# SYSTEM DESIGN
The proposed system has both hardware and software components. The hardware components 
(sensors) collect real time data and store it in cloud. The software component collects the stored 
data and processes it to make valid predictions. 
### A bird view of the project is as follows:
![image](https://user-images.githubusercontent.com/79393700/167406767-116b2414-e1c9-49e0-b9d8-d808e114cfcd.png)

1. Machine Learning model: Different machine learning models are to be used and 
compared like:
1. Linear Regression
2. Logistic Regression
3. Random Forest
4. Decision Tree Classifier
5. MLP Classifier
6. Gradient Booster Classifier
7. Support Vector Classifier
Python has been used to build the model with the help of its various libraries such as 
numpy, sklearn, pandas, pickle-mixin, etc.
2. Hardware: IOT based sensors BMP-180 AND DHT11 have been used to collect weather 
data in realtime. Arduino UNO is used to simulate the circuit.
3. Cloud: ThingSpeak Cloud Platform has been used to store the real time data collected 
from the sensors.
4. Application: The android application has been built using Native Java with an easy to 
use user interface and authenticated logins.


## OUTPUT
![image](https://user-images.githubusercontent.com/79393700/167407066-47d685d6-1339-445f-84fc-b2cb89860bbf.png)
### Real-time weather monitoring
![image](https://user-images.githubusercontent.com/79393700/167407113-fcd748bd-8a00-4184-bb45-5e5f09d79a7e.png)
### Prediction:
![image](https://user-images.githubusercontent.com/79393700/167407195-b4e9fe92-13be-4a74-b9f9-0db75d05377e.png)

