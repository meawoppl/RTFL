package io.rtfl.vcs;

import org.kohsuke.github.GHCreateRepositoryBuilder;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import java.io.IOException;

public class GitHubUtil {
  private final GitHub gh;

  private GitHubUtil(GitHub gh) throws Exception {
    this.gh = gh;

    try {
      gh.checkApiUrlValidity();
    } catch (IOException e){
      throw new RuntimeException("Github connection not valid...");
    }
    System.out.println(gh.getMyself().getName());
  }

  public static GitHubUtil fromUserConfig() throws Exception{
    try {
      return new GitHubUtil(GitHubBuilder.fromPropertyFile().build());
    } catch (IOException e){
      throw new RuntimeException("No/invalid property file?");
    }

  }

  public void forkRepo(String name, boolean waitForReady) throws Exception {
    gh.getRepository(name).fork();

    if(!waitForReady)
      return;

  }

  public GitHub getClient() {
    return gh;
  }
}
