# Milestone 3: Deploying using Google Kubernetes Engine
## Objectives:
1. Get Familiar with Docker and Kubernetes.
2. Use Google Cloud Platform.
3. Deploy Maven WebApp over Google Kubernetes Engine.

## Repository:
[https://github.com/GeorgeDaoud3/SOFE3980U-Lab3.git](https://github.com/GeorgeDaoud3/SOFE3980U-Lab3.git)

Docker, Kubernetes and GKE
1.	Watch The following video to understand [Docker terminologies](https://youtu.be/rOTqprHv1YE).  
2.	To manage Docker images and applications, we will use Kubernetes, watch the following video to get familiar with [Kubernetes and its components](https://youtu.be/cC46cg5FFAM).

## Creating GCP account
1.	It’s recommended to create a new Gmail account, but you can use an already existing account.
2.	Go to [GCP official site](https://cloud.google.com/gcp). Be sure that you are using the correct account. Then, click on **Get Started for free** button  

   ![a1](figures/a1.jpg)  

3.	Fill the account information and accept the terms of services  

   ![a2](figures/a2.jpg)  

4.	In the next step, you will fill in your personal information and a credit card information. That information is to ensure that you are a real person. This will create a free account for 90 days and give you 300+ $ free credits. **No charges are made unless you upgrade to a paid Cloud Billing account**. Please read [the GCP billing verification](https://cloud.google.com/free/docs/free-cloud-features#billing_verification) for more information.  

   ![a3](figures/a3.jpg)  

5.	Fill in the final survey. Then, click **Done**. You can safely skip any given offers.  

   ![a4](figures/a4.jpg)  

6.	Get yourself familiar with
   * Dashboard: allows you to search and select available cloud services
   * project(s): a project usually named **My First Project** will be created but we can create, edit, and delete projects.
   * The console: By clicking the console icon, the console will be opened to you. The console is a Linux terminal that can be used to configure the cloud. Any commands that affect the console local OS will be temporary and lost whenever the session is closed while any change made to any cloud services will be permanent.  
      ![a5](figures/a5.jpg)  

      The console will be opened at the bottom of the page as shown in the following figure and from it we can exchange files and folders with your local computer by downloading or uploading them. You can also click **Open Editor** button to open the editor.  
      ![a6](figures/a6.jpg)  

   * Editor: It’s a text editor that allows you to edit plain text file as shown in the following figure. You can switch back to the console by clicking **Open Terminal** button  

      ![a7](figures/a7.jpg)  
      
## Setup Google Kubernetes Engine (GKE)
To setup GKE, execute the following commands through the console within your Google Cloud Platform (GCP) project.
   1. Set the default compute zone to **northamerica-northeast1-b** 
   ```cmd
   gcloud config set compute/zone northamerica-northeast1-b  
   ```
   2. Enable GKE by searching for **Kubernetes Engine**, select **Kubernetes Engine API**, click **Enable**. 
   
      ![MS3 figure1](figures/cl3-1.jpg)
   
   3. Wait until the API is enabled then, create a three-nodes cluster on GKE called **sofe4630u**. 
   ```cmd
   gcloud container clusters create sofe4630u --num-nodes=3 
   ```
      **Note**: if the authorization windows popped up, click Authorize 
      **Note**: if you got an error that there is no available resources to create the nodes, you may need to change the default compute zone (e.g. to **us-central1-a** ) 
