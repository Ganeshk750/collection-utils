

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.junit.jupiter.api.Test;

import java.util.*;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class BagUnitTest {

    @Test
    public void whenAdded_thenCountIsKept(){
        List<Integer> list = Arrays.asList(1,2,3,3,3,1,4);
        Bag<Integer> bag = new HashBag<>(list);
        assertThat(bag.getCount(1), equalTo(2));
    }

    @Test
    public void givenBag_whenBagAddAPILikeCollectionAPI_thenFalse(){
        Collection<Integer> collection = new ArrayList<>();

        // Collection contract defines that add() should return false
        assertThat(collection.add(9), is(true));

        //Even when element is already in the collection
        collection.add(1);
        assertThat(collection.add(1), is(true));

        Bag<Integer> bag = new HashBag<>();

        assertThat(bag.add(9), is(true));
        bag.add(1);
        assertThat(bag.add(1), is(not(true)));

    }

}
