package se.elijah.portfolioapplication.service;


import org.springframework.stereotype.Service;
import se.elijah.portfolioapplication.model.Project;

import java.util.List;

@Service
public class ProjectService {
    public List<Project> listProjects() {
        return List.of(
                new Project(
                        "Personal Portfolio Website",
                        "HTML, CSS, Java med Spring boot, AWS S3",
                        "A personal portfolio website to showcase my projects and skills.",
                        "https://myfilescloud.s3.eu-north-1.amazonaws.com/elijah.jpg",
                        "https://github.com/Elijah71176/TekniskProjekt"
                ),
                new Project(
                        "S3 Demo",
                        "Upload/download files to S3 with AWS SDK v2.",
                        "Java, AWS SDK v2, S3",
                        "https://myfilescloud.s3.eu-north-1.amazonaws.com/jensen+skola.jpg",
                        "https://github.com/Elijah71176/s3demoCrud"
                )
        );
    }
}
