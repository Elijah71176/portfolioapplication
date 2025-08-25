package se.elijah.portfolioapplication.model;

public class Project {

    //private attributes
    private String title;
    private String techStack;
    private String description;
    private String imageUrl; // it can s3 link too
    private String githubUrl; // gitHub links

    public  Project() {} //


    //constructors with parameters
    public Project(String title, String techStack, String description, String imageUrl, String githubUrl) {
        this.title = title;
        this.techStack = techStack;
        this.description = description;
        this.imageUrl = imageUrl;
        this.githubUrl = githubUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }
}
