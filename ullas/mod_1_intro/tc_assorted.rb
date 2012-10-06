require "./assorted"
require "test/unit"

class TestSort < Test::Unit::TestCase
  def test_bubble_sort
    assert_equal([], [].bubble_sort)
    assert_equal([1], [1].bubble_sort)
    assert_equal([1,2], [1,2].bubble_sort)
    assert_equal([1,2,3], [2,1,3].bubble_sort)
    assert_equal([1,2,2,3], [2,1,2,3].bubble_sort)
  end

  def test_selection_sort
    assert_equal([], [].selection_sort)
    assert_equal([1], [1].selection_sort)
    assert_equal([1,2], [1,2].selection_sort)
    assert_equal([1,2,3], [2,1,3].selection_sort)
    assert_equal([1,2,2,3], [2,1,2,3].selection_sort)
  end

  def test_insertion_sort
    assert_equal([], [].insertion_sort)
    assert_equal([1], [1].insertion_sort)
    assert_equal([1,2], [1,2].insertion_sort)
    assert_equal([1,2,3], [2,1,3].insertion_sort)
    assert_equal([1,2,2,3], [2,1,2,3].insertion_sort)
  end

  def test_merge_sort
    assert_equal([], [].merge_sort)
    assert_equal([1], [1].merge_sort)
    assert_equal([1,2], [1,2].merge_sort)
    assert_equal([1,2,3], [2,1,3].merge_sort)
    assert_equal([1,2,2,3], [2,1,2,3].merge_sort)
  end
end
