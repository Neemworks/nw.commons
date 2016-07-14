### About Project
This project consists of basic functions used often in our software development cycle
* Logging
* Reading and Writing Properties Files
* BCrypt implementation by Damien Miller <djm@mindrot.org>
* Simple Base64 encoding and decoding
* Simple StopWatch
* A base loop process for implementing infinite loops
* A factory for spawning threads

#### Add Dependencies
Hosted on maven central

``` xml
  <dependency>
    	<groupId>com.nimworks</groupId>
    	<artifactId>nw.commons</artifactId>
    	<version>1.3.1</version>
    </dependency>
```

### Sample Usage
#### Logging and Properties Files

``` java
public class AppBase extends NeemClazz {

   public void setTargetPropertyFilename(){
      this.targetPropertiesFilename = "app.properties";
   }
}

public class App extends AppBase {
  public void doSth(){
    Integer myKey = appProps.getInt("my-key",-1); // key, defaultValue
    logger.debug("my-key: " + myKey); //logger is auto loaded since the parent extends NeemClazz
    appProps.set("my-key", "20", "Some comments");
    myKey = appProps.getInt("my-key",-1);
    logger.debug("my-key: " + myKey);
    ...
  }
}
```

#### Loop Process
``` java
public class Looper extends LoopProcess {
  
  public void process(){
      // do your work here
  }
  
  public static main(String[] args){
    AsyncFactory.spawnRunnable(new Looper(), "loop-process");
    // above is short for
    Thread t = new Thread(new Looper());
    t.setName("loop-process");
    t.start();
  }
}
```
