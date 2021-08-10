package com.polofox.http.header;
import com.polofox.http.header.accept.Accept_Ranges;
import com.polofox.http.header.age.Age;
import com.polofox.http.header.eTag.ETag;
import com.polofox.http.header.location.Location;
import com.polofox.http.header.retry.Retry_After;
import lombok.Data;
import java.io.Serializable;
@Data
public class ReqHeader extends Header implements Serializable {
        private Accept_Ranges<String> accept_ranges;
        private Age<Long> age;
        private ETag<String> eTag;
        private Location<String> location;
        private Retry_After<Integer> retry_after;
}
