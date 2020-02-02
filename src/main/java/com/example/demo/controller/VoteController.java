package com.example.demo.controller;

import com.example.demo.domain.lombok.Link;
import com.example.demo.domain.lombok.Vote;
import com.example.demo.repository.LinkRepository;
import com.example.demo.repository.VoteRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class VoteController {

    private LinkRepository linkRepository;
    private VoteRepository voteRepository;

    public VoteController(LinkRepository linkRepository, VoteRepository voteRepository) {
        this.linkRepository = linkRepository;
        this.voteRepository = voteRepository;
    }

    @Secured("ROLE_USER")
    @GetMapping("/vote/link/{linkId}/direction/{direction}/votecount/{voteCount}")
    public int vote(@PathVariable Long linkId, @PathVariable short direction, @PathVariable int voteCount) {

        Optional<Link> optionalLink = linkRepository.findById(linkId);
        if(optionalLink.isPresent()) {
            Link link = optionalLink.get();
            Vote vote = new Vote(direction, link);
            voteRepository.save(vote);
            int updateVoteCount = voteCount + direction;
            link.setVoteCount(updateVoteCount);
            linkRepository.save(link);
            return updateVoteCount;
        }
        return voteCount;
    }
}
