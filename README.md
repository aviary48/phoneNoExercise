# PhoneNoExercise
## How to BootUp the appliaction

### Step 1: to build the docker image
  > ` docker build -t jumiatakehome:1 . `

### step 2: make sure image is created
 > ` docker images | grep jumiatakehome `

### Step 3: run docker image on port 2224
 > ` docker run -d --name jumiatakehome -p 2224:2224 jumiatakehome:1 `

### Step 4: make sure container container build successfully
  > `  docker ps -a | grep jumiatakehome `

### Step 5: Check application logs to make sure app run successfully
  > ` docker logs -f bootdocker `
