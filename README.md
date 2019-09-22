<h1>Space Challenge</h1>

<p> This is the final project from Udacity's Object Oriented 
    Programming in Java.
</p>
<p>
In this project, I build a simulation that will help with mission to Mars!
The mission is to send a list of items (Habitats, bunkers, food supplies, and rovers) to Mars, but need to run some simulations 
first to pick the correct fleet of rockets.
There are 2 rocket prototypes design, but need help to design and run some simulations 
to help us decide which type to use.
</p>

<h4>U-1</h4>
<p>
The U-1 Rocket is light weight, agile and pretty safe, but can only carry a total of 18 tonnes of cargo. 
It costs $100 Million to build and weighs 10 tonnes. It has a slim chance of crashing while landing but a bigger chance of exploding when launching, both chances depend on the amount of cargo carried in the rocket.
</p>

<h4>U-2</h4>
<p>
The U2 Rocket heavier than the U-1 but much safer and can carry a lot more cargo; to a total of 29 tonnes. However, it costs $120 Million to build and weighs 18 tonnes. 
It has a greater chance of crashing while landing than while launching, but just like the U-1 both chances depend on the amount of cargo carried.
</p>

<h4>How the app works</h4>
<p>
    The app takes 3 arguments:
    <ol>
        <li>The type of rocket (U-1 or U-2)</li>
        <li>The full path to file containing Phase 1 items (list of items to be loaded in Phase 1)</li>
        <li>The full path to file containing Phase 2 items (list of items to be loaded in Phase 2)</li>
    </ol>
</p>

<h4>How to build and run the app</h4>
<p>
    Prerequisite:
    <ul>
       <li>JDK 8 or above installed</li>
       <li>Maven installed</li> 
    </ul>
    To build and run the app, follow the below steps:
    <ol>
        <li>run: $git clone https://github.com/Senopratomo/spacechallenge.git</li>
        <li>go to the 'spacechallenge' directory - $cd spacechallenge</li>
        <li>run: $mvn clean install</li>
        <li>run: $java -jar target/spacechallenge-1.0-SNAPSHOT-jar-with-dependencies.jar <-rocket_type-> <-Full-path-to-phase1-file-> <-Full-path-to-phase2-file->
        Eg: $java -jar target/spacechallenge-1.0-SNAPSHOT-jar-with-dependencies.jar U1 /home/user/Phase1.txt /home/user/Phase2.txt 
        </li>
    </ol>
</p>
